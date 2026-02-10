package edu.uajs.listas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 * Gestor de Tareas con menú interactivo (con ArrayList).
 * Listo para usar en clase: agregar, listar, editar, buscar, ordenar, guardar/cargar.
 */
public class Main {

    // ---- Modelo simple de tarea ----
    static class Tarea {
        private final int id;
        private String descripcion;
        private int prioridad; // 1 (alta) .. 5 (baja)
        private boolean completada;

        public Tarea(int id, String descripcion, int prioridad) {
            this.id = id;
            this.descripcion = descripcion;
            this.prioridad = prioridad;
            this.completada = false;
        }

        public int getId() { return id; }
        public String getDescripcion() { return descripcion; }
        public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
        public int getPrioridad() { return prioridad; }
        public void setPrioridad(int prioridad) { this.prioridad = prioridad; }
        public boolean isCompletada() { return completada; }
        public void setCompletada(boolean completada) { this.completada = completada; }

        @Override
        public String toString() {
            String estado = completada ? "✅" : "⏳";
            String prio = switch (prioridad) {
                case 1 -> "1 (ALTA)";
                case 2 -> "2";
                case 3 -> "3 (MEDIA)";
                case 4 -> "4";
                case 5 -> "5 (BAJA)";
                default -> String.valueOf(prioridad);
            };
            return String.format("#%d [%s] %s | Prioridad: %s", id, estado, descripcion, prio);
        }

        // Para guardar en CSV sencillo (evitar comas en descripción o escaparlas)
        public String toCsv() {
            String safeDesc = descripcion.replace(",", " "); // simple
            return id + "," + safeDesc + "," + prioridad + "," + (completada ? 1 : 0);
        }

        public static Tarea fromCsv(String line) {
            String[] p = line.split(",");
            if (p.length < 4) return null;
            int id = Integer.parseInt(p[0].trim());
            String desc = p[1].trim();
            int pr = Integer.parseInt(p[2].trim());
            boolean done = Integer.parseInt(p[3].trim()) == 1;
            Tarea t = new Tarea(id, desc, pr);
            t.setCompletada(done);
            return t;
        }
    }

    // ---- “Repositorio” en memoria usando ArrayList ----
    static class GestorTareas {
        private final List<Tarea> tareas = new ArrayList<>();
        private int nextId = 1;

        public Tarea agregar(String descripcion, int prioridad) {
            Tarea t = new Tarea(nextId++, descripcion, prioridad);
            tareas.add(t);
            return t;
        }

        public boolean eliminar(int id) {
            return tareas.removeIf(t -> t.getId() == id);
        }

        public Tarea buscarPorId(int id) {
            for (Tarea t : tareas) if (t.getId() == id) return t;
            return null;
        }

        public List<Tarea> listar() {
            return Collections.unmodifiableList(tareas);
        }

        public List<Tarea> buscarPorTexto(String texto) {
            String q = texto.toLowerCase();
            List<Tarea> res = new ArrayList<>();
            for (Tarea t : tareas) {
                if (t.getDescripcion().toLowerCase().contains(q)) res.add(t);
            }
            return res;
        }

        public void ordenarPorPrioridadAsc() {
            tareas.sort(Comparator.comparingInt(Tarea::getPrioridad).thenComparingInt(Tarea::getId));
        }

        public void ordenarPorEstadoLuegoPrioridad() {
            tareas.sort(Comparator
                    .comparing(Tarea::isCompletada) // false (pendiente) primero
                    .thenComparingInt(Tarea::getPrioridad)
                    .thenComparingInt(Tarea::getId));
        }

        public void limpiar() {
            tareas.clear();
            nextId = 1;
        }

        // --- Persistencia muy sencilla en CSV ---
        public void guardarEnArchivo(Path path) throws IOException {
            try (BufferedWriter bw = Files.newBufferedWriter(path)) {
                for (Tarea t : tareas) {
                    bw.write(t.toCsv());
                    bw.newLine();
                }
            }
        }

        public void cargarDesdeArchivo(Path path) throws IOException {
            if (!Files.exists(path)) return;
            limpiar();
            try (BufferedReader br = Files.newBufferedReader(path)) {
                String line;
                int maxId = 0;
                while ((line = br.readLine()) != null) {
                    Tarea t = Tarea.fromCsv(line);
                    if (t != null) {
                        tareas.add(t);
                        if (t.getId() > maxId) maxId = t.getId();
                    }
                }
                nextId = maxId + 1;
            }
        }
    }

    // ---- Utilidades de entrada segura por consola ----
    static class Console {
        private static final Scanner sc = new Scanner(System.in);

        public static int leerEntero(String prompt, int min, int max) {
            while (true) {
                System.out.print(prompt);
                String s = sc.nextLine().trim();
                try {
                    int v = Integer.parseInt(s);
                    if (v < min || v > max) {
                        System.out.printf("⚠️ Ingrese un número entre %d y %d%n", min, max);
                        continue;
                    }
                    return v;
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Valor no válido. Intente de nuevo.");
                }
            }
        }

        public static String leerLinea(String prompt, boolean requerido) {
            while (true) {
                System.out.print(prompt);
                String s = sc.nextLine();
                if (requerido && s.trim().isEmpty()) {
                    System.out.println("⚠️ Campo requerido. Intente de nuevo.");
                    continue;
                }
                return s;
            }
        }

        public static boolean confirmar(String prompt) {
            while (true) {
                System.out.print(prompt + " (s/n): ");
                String s = sc.nextLine().trim().toLowerCase();
                if (s.equals("s")) return true;
                if (s.equals("n")) return false;
                System.out.println("Responda con 's' o 'n'.");
            }
        }
    }

    // ---- Programa principal con menú ----
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Path archivo = Paths.get("tareas.csv"); // se guarda en el directorio de ejecución

        // Cargar si existe
        try {
            gestor.cargarDesdeArchivo(archivo);
        } catch (IOException e) {
            System.out.println("ℹ️ No se pudo cargar archivo inicial (se creará al guardar).");
        }

        while (true) {
            mostrarMenu();
            int op = Console.leerEntero("Elija una opción: ", 0, 9);
            switch (op) {
                case 1 -> accionAgregar(gestor);
                case 2 -> accionListar(gestor);
                case 3 -> accionCompletar(gestor);
                case 4 -> accionEditar(gestor);
                case 5 -> accionEliminar(gestor);
                case 6 -> accionBuscar(gestor);
                case 7 -> accionOrdenarPrioridad(gestor);
                case 8 -> accionOrdenarEstado(gestor);
                case 9 -> accionGuardar(gestor, archivo);
                case 0 -> {
                    if (Console.confirmar("¿Desea salir?"))
                        System.out.println("¡Listo! Clase salvada. 🎓");
                    else
                        break;
                    return;
                }
            }
            System.out.println();
        }
    }

    private static void mostrarMenu() {
        System.out.println("====================================");
        System.out.println("   GESTOR DE TAREAS (Listas Java)   ");
        System.out.println("====================================");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Editar tarea");
        System.out.println("5. Eliminar tarea");
        System.out.println("6. Buscar tareas por texto");
        System.out.println("7. Ordenar por prioridad (1..5)");
        System.out.println("8. Ordenar por estado (pendiente→completada) y prioridad");
        System.out.println("9. Guardar en archivo (CSV)");
        System.out.println("0. Salir");
    }

    // ---- Acciones del menú ----
    private static void accionAgregar(GestorTareas gestor) {
        String desc = Console.leerLinea("Descripción: ", true);
        int pr = Console.leerEntero("Prioridad (1=ALTA .. 5=BAJA): ", 1, 5);
        Tarea t = gestor.agregar(desc, pr);
        System.out.println("✅ Agregada: " + t);
    }

    private static void accionListar(GestorTareas gestor) {
        List<Tarea> lista = gestor.listar();
        if (lista.isEmpty()) {
            System.out.println("No hay tareas. (Aún 😉)");
            return;
        }
        System.out.println("---- Tareas ----");
        for (Tarea t : lista) System.out.println(t);
    }

    private static void accionCompletar(GestorTareas gestor) {
        int id = Console.leerEntero("ID a completar: ", 1, Integer.MAX_VALUE);
        Tarea t = gestor.buscarPorId(id);
        if (t == null) {
            System.out.println("⚠️ No existe una tarea con ese ID.");
            return;
        }
        t.setCompletada(true);
        System.out.println("✅ Marcada como completada: " + t);
    }

    private static void accionEditar(GestorTareas gestor) {
        int id = Console.leerEntero("ID a editar: ", 1, Integer.MAX_VALUE);
        Tarea t = gestor.buscarPorId(id);
        if (t == null) {
            System.out.println("⚠️ No existe una tarea con ese ID.");
            return;
        }
        String nuevaDesc = Console.leerLinea("Nueva descripción (Enter para mantener): ", false);
        if (!nuevaDesc.trim().isEmpty()) t.setDescripcion(nuevaDesc);
        int nuevaPr = Console.leerEntero("Nueva prioridad (1..5, actual " + t.getPrioridad() + "): ", 1, 5);
        t.setPrioridad(nuevaPr);
        System.out.println("✏️ Editada: " + t);
    }

    private static void accionEliminar(GestorTareas gestor) {
        int id = Console.leerEntero("ID a eliminar: ", 1, Integer.MAX_VALUE);
        boolean ok = gestor.eliminar(id);
        System.out.println(ok ? "🗑️ Eliminada con éxito." : "⚠️ No se encontró el ID.");
    }

    private static void accionBuscar(GestorTareas gestor) {
        String q = Console.leerLinea("Texto a buscar: ", true);
        List<Tarea> res = gestor.buscarPorTexto(q);
        if (res.isEmpty()) {
            System.out.println("Sin coincidencias.");
            return;
        }
        System.out.println("Resultados:");
        for (Tarea t : res) System.out.println(t);
    }

    private static void accionOrdenarPrioridad(GestorTareas gestor) {
        gestor.ordenarPorPrioridadAsc();
        System.out.println("↕️ Ordenadas por prioridad ascendente.");
        accionListar(gestor);
    }

    private static void accionOrdenarEstado(GestorTareas gestor) {
        gestor.ordenarPorEstadoLuegoPrioridad();
        System.out.println("↕️ Ordenadas por estado y prioridad.");
        accionListar(gestor);
    }

    private static void accionGuardar(GestorTareas gestor, Path archivo) {
        try {
            gestor.guardarEnArchivo(archivo);
            System.out.println("💾 Guardado en: " + archivo.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("❌ Error al guardar: " + e.getMessage());
        }
    }
}
