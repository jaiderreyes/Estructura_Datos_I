/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vectorcalzado5;
import java.util.Scanner;
import java.util.Vector;
/**
 *
 * @author jaiderreyes
 */
public class Vectorcalzado5 {

    public static void main(String[] args) {
        Vector<String> modelos = new Vector<>();
        Vector<Integer> tallas = new Vector<>();
        Vector<Double> precios = new Vector<>();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Tienda de Calzados ---");
            System.out.println("1. Agregar calzado");
            System.out.println("2. Listar calzados");
            System.out.println("3. Modificar calzado");
            System.out.println("4. Eliminar calzado");
            System.out.println("5. Mostrar valor total del inventario");
            System.out.println("6. Vender calzado");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.print("Modelo: ");
                sc.nextLine(); // limpiar buffer
                String modelo = sc.nextLine();
                System.out.print("Talla: ");
                int talla = sc.nextInt();
                System.out.print("Precio: ");
                double precio = sc.nextDouble();

                modelos.add(modelo);
                tallas.add(talla);
                precios.add(precio);
                System.out.println("Calzado agregado.");

            } else if (opcion == 2) {
                if (modelos.isEmpty()) {
                    System.out.println("Inventario vacío.");
                } else {
                    System.out.println("Inventario:");
                    for (int i = 0; i < modelos.size(); i++) {
                        System.out.printf("[%d] Modelo: %s, Talla: %d, Precio: $%.2f%n",
                                i, modelos.get(i), tallas.get(i), precios.get(i));
                    }
                }

            } else if (opcion == 3) {
                if (modelos.isEmpty()) {
                    System.out.println("Nada que modificar.");
                } else {
                    System.out.print("Índice a modificar: ");
                    int idx = sc.nextInt();
                    if (idx >= 0 && idx < modelos.size()) {
                        System.out.print("Nuevo modelo: ");
                        sc.nextLine(); // limpiar buffer
                        String nuevoModelo = sc.nextLine();
                        System.out.print("Nueva talla: ");
                        int nuevaTalla = sc.nextInt();
                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = sc.nextDouble();

                        modelos.set(idx, nuevoModelo);
                        tallas.set(idx, nuevaTalla);
                        precios.set(idx, nuevoPrecio);
                        System.out.println("Calzado modificado.");
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                }

            } else if (opcion == 4) {
                if (modelos.isEmpty()) {
                    System.out.println("Nada que eliminar.");
                } else {
                    System.out.print("Índice a eliminar: ");
                    int idx = sc.nextInt();
                    if (idx >= 0 && idx < modelos.size()) {
                        modelos.remove(idx);
                        tallas.remove(idx);
                        precios.remove(idx);
                        System.out.println("Calzado eliminado.");
                    } else {
                        System.out.println("Índice fuera de rango.");
                    }
                }

            } else if (opcion == 5) {
                // Calcular total del inventario
                double total = 0;
                for (int i = 0; i < precios.size(); i++) {
                    total += precios.get(i);
                }
                System.out.printf("Valor total del inventario: $%.2f%n", total);

            } else if (opcion == 6) {
                if (modelos.isEmpty()) {
                    System.out.println("No hay productos para vender.");
                } else {
                    System.out.print("Índice del calzado a vender: ");
                    int idx = sc.nextInt();
                    if (idx >= 0 && idx < modelos.size()) {
                        System.out.printf("Vendido: %s (Talla %d) por $%.2f%n",
                                modelos.get(idx), tallas.get(idx), precios.get(idx));
                        modelos.remove(idx);
                        tallas.remove(idx);
                        precios.remove(idx);
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
