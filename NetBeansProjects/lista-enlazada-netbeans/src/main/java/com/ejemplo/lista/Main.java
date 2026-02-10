package com.ejemplo.lista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ListaEnlazada lista = new ListaEnlazada();
            int opcion = -1;
            
            while (opcion != 0) {
                System.out.println("\n--- MENÚ LISTA ENLAZADA SIMPLE ---");
                System.out.println("1. Insertar al final");
                System.out.println("2. Insertar al inicio");
                System.out.println("3. Buscar elemento");
                System.out.println("4. Eliminar elemento");
                System.out.println("5. Mostrar lista");
                System.out.println("6. Mostrar tamaño");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                
                try {
                    opcion = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor ingrese un número.");
                    sc.nextLine();
                    continue;
                }
                
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese el valor a insertar: ");
                        int valor = sc.nextInt();
                        lista.insertar(valor);
                        System.out.println("Insertado al final.");
                    }
                    case 2 -> {
                        System.out.print("Ingrese el valor a insertar al inicio: ");
                        int valor = sc.nextInt();
                        lista.insertarInicio(valor);
                        System.out.println("Insertado al inicio.");
                    }
                    case 3 -> {
                        System.out.print("Ingrese el valor a buscar: ");
                        int valor = sc.nextInt();
                        System.out.println(lista.buscar(valor) ? "Elemento encontrado." : "Elemento no encontrado.");
                    }
                    case 4 -> {
                        System.out.print("Ingrese el valor a eliminar: ");
                        int valor = sc.nextInt();
                        System.out.println(lista.eliminar(valor) ? "Elemento eliminado." : "Elemento no encontrado.");
                    }
                    case 5 -> {
                        System.out.println("Lista actual:");
                        lista.mostrar();
                    }
                    case 6 -> {
                        System.out.println("Tamaño de la lista: " + lista.tamaño());
                    }
                    case 0 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción no válida.");
                }
            }
        }
    }
}
