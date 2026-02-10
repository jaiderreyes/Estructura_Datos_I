/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vector2;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author jaiderreyes
 */
public class Vector2 {

    public static void main(String[] args) {
      Vector<Integer> vector = new Vector<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- CRUD con Vector<Integer> ---");
            System.out.println("1. Agregar elemento (Create)");
            System.out.println("2. Listar elementos (Read)");
            System.out.println("3. Modificar elemento (Update)");
            System.out.println("4. Eliminar elemento (Delete)");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    crear(vector, sc);
                    break;
                case 2:
                    leer(vector);
                    break;
                case 3:
                    actualizar(vector, sc);
                    break;
                case 4:
                    eliminar(vector, sc);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    // Create
    private static void crear(Vector<Integer> v, Scanner sc) {
        System.out.print("Número a agregar: ");
        int valor = sc.nextInt();
        v.add(valor);
        System.out.println("Agregado: " + valor);
    }

    // Read
    private static void leer(Vector<Integer> v) {
        if (v.isEmpty()) {
            System.out.println("El Vector está vacío.");
        } else {
            System.out.println("Contenido del Vector:");
            for (int i = 0; i < v.size(); i++) {
                System.out.printf("Índice %d → %d%n", i, v.get(i));
            }
        }
    }

    // Update
    private static void actualizar(Vector<Integer> v, Scanner sc) {
        if (v.isEmpty()) {
            System.out.println("Nada que modificar, el Vector está vacío.");
            return;
        }
        System.out.print("Índice a modificar: ");
        int idx = sc.nextInt();
        if (idx >= 0 && idx < v.size()) {
            System.out.print("Nuevo valor: ");
            int nuevo = sc.nextInt();
            int viejo = v.set(idx, nuevo);
            System.out.printf("Reemplazado %d → %d en índice %d%n", viejo, nuevo, idx);
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    // Delete
    private static void eliminar(Vector<Integer> v, Scanner sc) {
        if (v.isEmpty()) {
            System.out.println("Nada que eliminar, el Vector está vacío.");
            return;
        }
        System.out.print("Índice a eliminar: ");
        int idx = sc.nextInt();
        if (idx >= 0 && idx < v.size()) {
            int eliminado = v.remove(idx);
            System.out.printf("Eliminado %d del índice %d%n", eliminado, idx);
        } else {
            System.out.println("Índice fuera de rango.");
        }
    
    }
}
