/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vector3;
import java.util.Scanner;
import java.util.Vector;
/**
 *
 * @author jaiderreyes
 */
public class Vector3 {

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            // 1) Mostrar menú
            System.out.println("\n--- CRUD con Vector<Integer> ---");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Listar elementos");
            System.out.println("3. Modificar elemento");
            System.out.println("4. Eliminar elemento");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");
            opcion = sc.nextInt();

            // 2) Procesar opción
            if (opcion == 1) {
                // Create
                System.out.print("Número a agregar: ");
                int valor = sc.nextInt();
                vector.add(valor);
                System.out.println("Agregado: " + valor);

            } else if (opcion == 2) {
                // Read
                if (vector.isEmpty()) {
                    System.out.println("Vector vacío.");
                } else {
                    System.out.println("Contenido del Vector:");
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.printf("Índice %d → %d%n", i, vector.get(i));
                    }
                }

            } else if (opcion == 3) {
                // Update
                if (vector.isEmpty()) {
                    System.out.println("Nada que modificar.");
                } else {
                    System.out.print("Índice a modificar: ");
                    int idx = sc.nextInt();
                    if (idx >= 0 && idx < vector.size()) {
                        System.out.print("Nuevo valor: ");
                        int nuevo = sc.nextInt();
                        int viejo = vector.set(idx, nuevo);
                        System.out.printf("Reemplazado %d → %d en índice %d%n", viejo, nuevo, idx);
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                }

            } else if (opcion == 4) {
                // Delete
                if (vector.isEmpty()) {
                    System.out.println("Nada que eliminar.");
                } else {
                    System.out.print("Índice a eliminar: ");
                    int idx = sc.nextInt();
                    if (idx >= 0 && idx < vector.size()) {
                        int eliminado = vector.remove(idx);
                        System.out.printf("Eliminado %d del índice %d%n", eliminado, idx);
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                }

            } else if (opcion == 0) {
                System.out.println("Fin del programa.");

            } else {
                System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
