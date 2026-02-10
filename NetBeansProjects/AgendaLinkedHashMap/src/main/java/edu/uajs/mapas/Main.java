package edu.uajs.mapas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Proyecto sencillo de consola para demostrar LinkedHashMap.
 * Caso de uso: Agenda (nombre -> teléfono), preservando el ORDEN de inserción.
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    // LinkedHashMap preserva el orden de inserción (a diferencia de HashMap).
    private static final LinkedHashMap<String, String> agenda = new LinkedHashMap<>();

    public static void main(String[] args) {
        precargarEjemplos(); // para que la primera corrida ya muestre algo

        while (true) {
            mostrarMenu();
            int op = leerEntero("Elija opción: ", 0, 6);

            switch (op) {
                case 1 -> agregarContacto();
                case 2 -> consultarTelefono();
                case 3 -> actualizarTelefono();
                case 4 -> eliminarContacto();
                case 5 -> listarOrdenInsercion();
                case 6 -> listarOrdenAcceso();
                case 0 -> {
                    System.out.println("¡Hasta luego!");
                    return;
                }
            }
            System.out.println();
        }
    }

    private static void mostrarMenu() {
        System.out.println("=============================");
        System.out.println(" AGENDA - LinkedHashMap 🗂️ ");
        System.out.println("=============================");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Consultar teléfono por nombre");
        System.out.println("3. Actualizar teléfono");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Listar (orden de inserción)");
        System.out.println("6. Listar (simular orden de acceso)");
        System.out.println("0. Salir");
    }

    private static void agregarContacto() {
        String nombre = leerCadena("Nombre: ", true);
        if (agenda.containsKey(nombre)) {
            System.out.println("⚠️ Ya existe. Use opción 3 para actualizar.");
            return;
        }
        String tel = leerCadena("Teléfono: ", true);
        agenda.put(nombre, tel); // putIfAbsent también serviría
        System.out.println("✅ Agregado: " + nombre + " -> " + tel);
    }

    private static void consultarTelefono() {
        String nombre = leerCadena("Nombre a consultar: ", true);
        String tel = agenda.get(nombre);
        if (tel == null) {
            System.out.println("No existe ese contacto.");
            return;
        }
        System.out.println("📞 " + nombre + " -> " + tel);
    }

    private static void actualizarTelefono() {
        String nombre = leerCadena("Nombre a actualizar: ", true);
        if (!agenda.containsKey(nombre)) {
            System.out.println("No existe ese contacto.");
            return;
        }
        String tel = leerCadena("Nuevo teléfono: ", true);
        agenda.replace(nombre, tel); // también: agenda.put(nombre, tel);
        System.out.println("✏️ Actualizado: " + nombre + " -> " + tel);
    }

    private static void eliminarContacto() {
        String nombre = leerCadena("Nombre a eliminar: ", true);
        if (agenda.remove(nombre) != null) {
            System.out.println("🗑️ Eliminado: " + nombre);
        } else {
            System.out.println("No existía ese contacto.");
        }
    }

    private static void listarOrdenInsercion() {
        if (agenda.isEmpty()) {
            System.out.println("(Agenda vacía)");
            return;
        }
        System.out.println("Listado (orden de inserción):");
        for (Map.Entry<String, String> e : agenda.entrySet()) {
            System.out.println("• " + e.getKey() + " -> " + e.getValue());
        }
    }

    /**
     * Demostración simple: al consultar algunos contactos antes de listar,
     * podemos simular "orden de acceso" imprimiendo primero los consultados.
     * Nota: LinkedHashMap soporta un constructor con accessOrder=true,
     * pero aquí lo hacemos de manera explícita para mantener el ejemplo fácil.
     */
    private static void listarOrdenAcceso() {
        if (agenda.isEmpty()) {
            System.out.println("(Agenda vacía)");
            return;
        }
        // Paso 1: preguntar qué nombres se consultaron recientemente
        System.out.println("Ingrese nombres consultados recientemente separados por coma (o Enter): ");
        String linea = sc.nextLine().trim();

        if (linea.isEmpty()) {
            listarOrdenInsercion();
            return;
        }

        String[] consultados = linea.split(",");
        // Paso 2: imprimimos primero los consultados, en el orden dado, si existen
        System.out.println("Listado (priorizando consultados):");
        LinkedHashMap<String, String> restantes = new LinkedHashMap<>(agenda);
        for (String n : consultados) {
            String nombre = n.trim();
            if (restantes.containsKey(nombre)) {
                System.out.println("• " + nombre + " -> " + restantes.get(nombre) + "  (reciente)");
                restantes.remove(nombre);
            }
        }
        // Luego, el resto en orden de inserción original
        for (Map.Entry<String, String> e : restantes.entrySet()) {
            System.out.println("• " + e.getKey() + " -> " + e.getValue());
        }
    }

    private static void precargarEjemplos() {
        agenda.put("Ana", "3001112233");
        agenda.put("Bruno", "3012223344");
        agenda.put("Carla", "3023334455");
    }

    private static int leerEntero(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) {
                    System.out.printf("Ingrese un número entre %d y %d%n", min, max);
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Valor no válido.");
            }
        }
    }

    private static String leerCadena(String prompt, boolean requerido) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            if (requerido && s.trim().isEmpty()) {
                System.out.println("Campo requerido.");
                continue;
            }
            return s;
        }
    }
}
