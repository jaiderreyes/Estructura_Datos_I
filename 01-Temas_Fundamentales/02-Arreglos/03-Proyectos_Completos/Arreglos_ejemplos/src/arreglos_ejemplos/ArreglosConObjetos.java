package arreglos_ejemplos;

/**
 * Clase principal con ejemplos de arreglos utilizando tipos primitivos y objetos.
 * 
 * Esta clase demuestra diferentes formas de crear, manipular y recorrer arreglos
 * en Java, incluyendo tipos primitivos, objetos String, objetos personalizados
 * y arreglos bidimensionales.
 * 
 * @author Profesor Jaider Reyes Herazo
 * @version 1.0
 * @since 2026
 */
public class ArreglosConObjetos {

    /**
     * Método principal que ejecuta todos los ejemplos de arreglos.
     * 
     * @param args Argumentos de línea de comandos (no utilizados en este ejemplo).
     */
    public static void main(String[] args) {
        
        // =================================================================================
        // EJEMPLO 1: Arreglo de tipos primitivos (enteros)
        // =================================================================================
        System.out.println("=== EJEMPLO 1: Arreglo de enteros ===");
        
        // Declaración y creación de un arreglo de 5 enteros
        // En Java, los arreglos tienen tamaño fijo una vez creados
        int[] numeros = new int[5];
        
        // Asignación de valores a cada posición del arreglo
        // Los índices en Java van de 0 a (tamaño-1)
        numeros[0] = 10;  // Primera posición (índice 0)
        numeros[1] = 20;  // Segunda posición (índice 1)
        numeros[2] = 30;  // Tercera posición (índice 2)
        numeros[3] = 40;  // Cuarta posición (índice 3)
        numeros[4] = 50;  // Quinta posición (índice 4)
        
        // Recorrido del arreglo usando bucle for tradicional
        // Este método nos permite acceder tanto al índice como al valor
        System.out.println("Recorrido con for tradicional:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("numeros[" + i + "] = " + numeros[i]);
        }
        
        // Recorrido del arreglo usando bucle for-each (for mejorado)
        // Este método es más简洁 y solo nos da acceso a los valores
        System.out.println("\nRecorrido con for-each:");
        for (int num : numeros) {
            System.out.println("Elemento: " + num);
        }
        
        // =================================================================================
        // EJEMPLO 2: Arreglo de objetos String
        // =================================================================================
        System.out.println("\n=== EJEMPLO 2: Arreglo de Strings ===");
        
        // Declaración e inicialización simultánea de un arreglo de Strings
        // Esta es una forma abreviada de crear e inicializar un arreglo
        String[] nombres = {"Ana", "Juan", "María", "Pedro", "Laura"};
        
        // Mostrar cada nombre del arreglo
        System.out.println("Lista de nombres:");
        for (String nombre : nombres) {
            System.out.println("- " + nombre);
        }
        
        // =================================================================================
        // EJEMPLO 3: Arreglo de objetos Estudiante (clase personalizada)
        // =================================================================================
        System.out.println("\n=== EJEMPLO 3: Arreglo de objetos Estudiante ===");
        
        // Creación de un arreglo que contendrá objetos de tipo Estudiante
        // Importante: Creamos el arreglo, pero aún no los objetos individuales
        Estudiante[] estudiantes = new Estudiante[4];
        
        // Creación de instancias de Estudiante y asignación al arreglo
        // Cada posición del arreglo ahora contiene un objeto Estudiante completamente inicializado
        estudiantes[0] = new Estudiante("Carlos Rodríguez", 20, 85.5);
        estudiantes[1] = new Estudiante("Sofía Martínez", 19, 92.3);
        estudiantes[2] = new Estudiante("Luis García", 21, 78.9);
        estudiantes[3] = new Estudiante("Elena López", 20, 88.7);
        
        // Acceso a los datos de los estudiantes usando métodos getter
        // Esto demuestra cómo trabajar con objetos dentro de arreglos
        System.out.println("Información de estudiantes:");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Estudiante " + (i + 1) + ":");
            System.out.println("  Nombre: " + estudiantes[i].getNombre());
            System.out.println("  Edad: " + estudiantes[i].getEdad());
            System.out.println("  Promedio: " + estudiantes[i].getPromedio());
            System.out.println();  // Línea en blanco para mejor legibilidad
        }
        
        // =================================================================================
        // EJEMPLO 4: Operaciones y algoritmos con arreglos
        // =================================================================================
        System.out.println("=== EJEMPLO 4: Operaciones con arreglos ===");
        
        // Operación 1: Calcular la suma de todos los elementos
        // Patrón de acumulación: inicializar variable, recorrer, acumular
        int suma = 0;
        for (int num : numeros) {
            suma += num;  // Equivalente a: suma = suma + num;
        }
        System.out.println("Suma de números: " + suma);
        
        // Operación 2: Encontrar el estudiante con el mayor promedio
        // Patrón de búsqueda: inicializar con el primer elemento, comparar, actualizar
        double mayorPromedio = estudiantes[0].getPromedio();
        String nombreMayor = estudiantes[0].getNombre();
        
        // Empezamos desde el segundo elemento (índice 1) porque el primero ya está como referencia
        for (int i = 1; i < estudiantes.length; i++) {
            if (estudiantes[i].getPromedio() > mayorPromedio) {
                mayorPromedio = estudiantes[i].getPromedio();
                nombreMayor = estudiantes[i].getNombre();
            }
        }
        System.out.println("Estudiante con mayor promedio: " + nombreMayor + " (" + mayorPromedio + ")");
        
        // =================================================================================
        // EJEMPLO 5: Arreglo bidimensional (matriz)
        // =================================================================================
        System.out.println("\n=== EJEMPLO 5: Arreglo bidimensional ===");
        
        // Creación de una matriz de 3x3 (3 filas, 3 columnas)
        int[][] matriz = new int[3][3];
        
        // Inicialización de la matriz con valores secuenciales
        // Usaremos un contador para asignar valores del 1 al 9
        int valor = 1;
        for (int i = 0; i < matriz.length; i++) {        // Recorre filas
            for (int j = 0; j < matriz[i].length; j++) {   // Recorre columnas
                matriz[i][j] = valor++;
            }
        }
        
        // Mostrar la matriz en formato tabular
        // Usamos \t (tabulador) para alinear los números
        System.out.println("Matriz 3x3:");
        for (int i = 0; i < matriz.length; i++) {        // Recorre filas
            for (int j = 0; j < matriz[i].length; j++) {   // Recorre columnas
                System.out.print(matriz[i][j] + "\t");      // print() sin salto de línea
            }
            System.out.println();  // Salto de línea después de cada fila
        }
    }
}