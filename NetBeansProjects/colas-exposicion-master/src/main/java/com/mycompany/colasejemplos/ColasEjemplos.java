package com.mycompany.colasejemplos;

import java.util.Scanner;

public class ColasEjemplos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ DE EJEMPLOS DE COLAS ===");
            System.out.println("1. Cola con arreglo circular (ColaCircularArray)");
            System.out.println("2. Cola con ArrayDeque (ColaConArrayDeque)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> ejecutarColaCircular();
                case 2 -> ejecutarColaDeque();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intenta nuevamente.");
            }

        } while (opcion != 0);

        sc.close();
    }

    // Llama al main de ColaCircularArray
    private static void ejecutarColaCircular() {
        System.out.println("\n--- Ejecutando ColaCircularArray ---");
        ColaCircularArray.main(new String[0]);
    }

    // Llama al main de ColaConArrayDeque
    private static void ejecutarColaDeque() {
        System.out.println("\n--- Ejecutando ColaConArrayDeque ---");
        ColaConArrayDeque.main(new String[0]);
    }
}
