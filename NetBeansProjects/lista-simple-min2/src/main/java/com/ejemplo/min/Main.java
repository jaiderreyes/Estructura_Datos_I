package com.ejemplo.min;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaSimple lista = new ListaSimple();
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- MENÚ MINIMAL ---");
            System.out.println("1. Insertar al final");
            System.out.println("2. Mostrar lista");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            if (!sc.hasNextInt()) {
                System.out.println("Ingrese un número válido.");
                sc.nextLine();
                continue;
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Valor a insertar: ");
                    if (sc.hasNextInt()) {
                        int valor = sc.nextInt();
                        lista.insertar(valor);
                        System.out.println("Insertado.");
                    } else {
                        System.out.println("Debe ser entero.");
                        sc.next(); // limpia token inválido
                    }
                }
                case 2 -> lista.mostrar();
                case 0 -> System.out.println("Adiós.");
                default -> System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}
