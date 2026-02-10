package arreglos_ejemplos;

import java.util.Scanner;

/**
 * Clase que implementa un sistema completo de gestión de estudiantes.
 * 
 * Esta aplicación demuestra el uso práctico de arreglos para almacenar
 * y manipular colecciones de objetos, con una interfaz de usuario interactiva
 * basada en consola.
 * 
 * @author Profesor Jaider Reyes Herazo
 * @version 1.0
 * @since 2026
 */
public class GestionEstudiantes {
    
    /**
     * Arreglo para almacenar los objetos Estudiante.
     * Este arreglo tiene una capacidad máxima fija definida al crear la instancia.
     */
    private Estudiante[] estudiantes;
    
    /**
     * Contador que lleva el registro de cuántos estudiantes han sido agregados.
     * También representa el primer índice disponible para agregar un nuevo estudiante.
     */
    private int contador;
    
    /**
     * Objeto Scanner para leer la entrada del usuario desde la consola.
     * Permite capturar diferentes tipos de datos (String, int, double).
     */
    private Scanner scanner;
    
    /**
     * Constructor de la clase GestionEstudiantes.
     * 
     * Inicializa el arreglo de estudiantes con la capacidad especificada,
     * establece el contador en cero y crea una nueva instancia de Scanner.
     * 
     * @param capacidad Número máximo de estudiantes que se pueden almacenar.
     */
    public GestionEstudiantes(int capacidad) {
        this.estudiantes = new Estudiante[capacidad];
        this.contador = 0;
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Agrega un nuevo estudiante al arreglo.
     * 
     * Este método solicita al usuario los datos del estudiante (nombre, edad, promedio),
     * valida que haya espacio disponible en el arreglo, crea una nueva instancia de
     * Estudiante y la almacena en la primera posición disponible.
     * 
     * Maneja el caso cuando el arreglo está lleno para evitar ArrayIndexOutOfBoundsException.
     */
    public void agregarEstudiante() {
        // Verificar si hay espacio disponible en el arreglo
        if (contador >= estudiantes.length) {
            System.out.println("No se pueden agregar más estudiantes. El arreglo está lleno.");
            return;  // Salir del método si no hay espacio
        }
        
        System.out.println("\n--- Agregar Nuevo Estudiante ---");
        
        // Solicitar y leer el nombre del estudiante
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        // Solicitar y leer la edad del estudiante
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer del salto de línea
        
        // Solicitar y leer el promedio del estudiante
        System.out.print("Promedio: ");
        double promedio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer del salto de línea
        
        // Crear nueva instancia de Estudiante y almacenarla en el arreglo
        estudiantes[contador] = new Estudiante(nombre, edad, promedio);
        contador++;  // Incrementar el contador para el próximo estudiante
        
        System.out.println("Estudiante agregado correctamente.");
    }
    
    /**
     * Muestra todos los estudiantes registrados en el sistema.
     * 
     * Recorre el arreglo hasta el contador de elementos y muestra la información
     * detallada de cada estudiante utilizando el método toString() de la clase Estudiante.
     * 
     * Maneja el caso cuando no hay estudiantes registrados.
     */
    public void mostrarEstudiantes() {
        // Verificar si hay estudiantes registrados
        if (contador == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        
        System.out.println("\n--- Lista de Estudiantes ---");
        
        // Recorrer solo las posiciones ocupadas del arreglo
        for (int i = 0; i < contador; i++) {
            System.out.println("\nEstudiante #" + (i + 1) + ":");
            System.out.println(estudiantes[i].toString());
        }
    }
    
    /**
     * Busca estudiantes por nombre (búsqueda parcial, case-insensitive).
     * 
     * Solicita al usuario un término de búsqueda y muestra todos los estudiantes
     * cuyo nombre contenga dicho término, sin importar mayúsculas o minúsculas.
     * 
     * Implementa una búsqueda lineal básica con coincidencia parcial.
     */
    public void buscarEstudiante() {
        // Verificar si hay estudiantes registrados
        if (contador == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        
        System.out.print("\nIngrese el nombre del estudiante a buscar: ");
        String nombreBusqueda = scanner.nextLine().toLowerCase();
        
        boolean encontrado = false;
        
        // Recorrer todos los estudiantes buscando coincidencias
        for (int i = 0; i < contador; i++) {
            // contains() permite coincidencias parciales
            // toLowerCase() hace la búsqueda case-insensitive
            if (estudiantes[i].getNombre().toLowerCase().contains(nombreBusqueda)) {
                System.out.println("\nEstudiante encontrado:");
                System.out.println(estudiantes[i].toString());
                encontrado = true;
            }
        }
        
        // Informar si no se encontraron resultados
        if (!encontrado) {
            System.out.println("No se encontraron estudiantes con ese nombre.");
        }
    }
    
    /**
     * Calcula y muestra el promedio general de todos los estudiantes.
     * 
     * Suma los promedios individuales de todos los estudiantes registrados
     * y calcula el promedio aritmético del grupo.
     * 
     * Utiliza printf() para formatear el resultado con dos decimales.
     */
    public void calcularPromedioGeneral() {
        // Verificar si hay estudiantes registrados
        if (contador == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        
        double sumaPromedios = 0;
        
        // Sumar los promedios de todos los estudiantes
        for (int i = 0; i < contador; i++) {
            sumaPromedios += estudiantes[i].getPromedio();
        }
        
        // Calcular el promedio dividiendo la suma entre el número de estudiantes
        double promedioGeneral = sumaPromedios / contador;
        
        // Mostrar el resultado formateado a 2 decimales
        System.out.printf("\nPromedio general del grupo: %.2f\n", promedioGeneral);
    }
    
    /**
     * Muestra el menú principal de la aplicación.
     * 
     * Implementa un ciclo do-while que muestra repetidamente el menú de opciones
     * y procesa la selección del usuario utilizando una estructura switch-case.
     * 
     * El ciclo continúa hasta que el usuario selecciona la opción de salir.
     */
    public void mostrarMenu() {
        int opcion;
        
        do {
            // Mostrar opciones del menú
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Mostrar todos los estudiantes");
            System.out.println("3. Buscar estudiante por nombre");
            System.out.println("4. Calcular promedio general");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Leer la opción seleccionada por el usuario
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer del salto de línea
            
            // Procesar la opción seleccionada
            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;
                case 2:
                    mostrarEstudiantes();
                    break;
                case 3:
                    buscarEstudiante();
                    break;
                case 4:
                    calcularPromedioGeneral();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            
        } while (opcion != 5);  // Continuar hasta que se seleccione la opción 5
        
        // Cerrar el Scanner para liberar recursos
        scanner.close();
    }
    
    /**
     * Método principal que inicia la aplicación.
     * 
     * Crea una instancia de GestionEstudiantes con capacidad para 10 estudiantes
     * y muestra el menú principal.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Crear instancia de la aplicación con capacidad para 10 estudiantes
        GestionEstudiantes app = new GestionEstudiantes(10);
        
        // Iniciar el menú interactivo
        app.mostrarMenu();
    }
}