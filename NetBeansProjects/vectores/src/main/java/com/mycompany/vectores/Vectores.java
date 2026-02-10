/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vectores;
import java.util.Scanner;

import java.util.Arrays;
/**
 *
 * @author jaiderreyes
 */
public class Vectores {

    public static void main(String[] args) {
          // Variables
       String[] nombres = new String[5];
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- CRUD Nombres ---");
            System.out.println("1. Agregar");
            System.out.println("2. Listar");
            System.out.println("3. Modificar");
            System.out.println("4. Eliminar");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  // limpiar buffer

            switch (opcion) {
                case 1:
                    if (count < nombres.length) {
                        System.out.print("Nombre a agregar: ");
                        nombres[count++] = sc.nextLine();
                    } else {
                        System.out.println("Arreglo lleno.");
                    }
                    break;
                case 2:
                    System.out.println("Lista de nombres:");
                    System.out.println(Arrays.toString(Arrays.copyOf(nombres, count)));
                    break;
                case 3:
                    System.out.print("Índice a modificar: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    if (idx >= 0 && idx < count) {
                        System.out.print("Nuevo nombre: ");
                        nombres[idx] = sc.nextLine();
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 4:
                    System.out.print("Índice a eliminar: ");
                    int idxE = sc.nextInt();
                    if (idxE >= 0 && idxE < count) {
                        for (int i = idxE; i < count - 1; i++) {
                            nombres[i] = nombres[i + 1];
                        }
                        count--;
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    sc.nextLine();
                    break;
                case 0:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
