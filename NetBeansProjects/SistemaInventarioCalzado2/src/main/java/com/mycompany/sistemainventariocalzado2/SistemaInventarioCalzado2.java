/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemainventariocalzado2;
import java.util.Scanner;


/**
 *
 * @author jaiderreyes
 */
public class SistemaInventarioCalzado2 {
    
private static InventarioCalzado inventario = new InventarioCalzado();
    private static Scanner scanner             = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1 -> agregar();
                case 2 -> buscar();
                case 3 -> eliminar();
                case 4 -> inventario.listar();
                case 0 -> System.out.println("Saliendo del sistema... ¡Hasta luego!");
                default -> System.out.println("Opción inválida, intenta de nuevo.");
            }
            System.out.println();
        } while (opcion != 0);
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("=== SISTEMA INVENTARIO CALZADO ===");
        System.out.println("1. Agregar calzado");
        System.out.println("2. Buscar calzado");
        System.out.println("3. Eliminar calzado");
        System.out.println("4. Listar inventario");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void agregar() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Talla: ");
        String talla = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.print("Cantidad: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        Calzado c = new Calzado(codigo, marca, talla, precio, cantidad);
        inventario.agregarCalzado(c);
    }

    private static void buscar() {
        System.out.print("Ingresa el código a buscar: ");
        String codigo = scanner.nextLine();
        Calzado c = inventario.buscarCalzado(codigo);
        if (c != null) {
            System.out.println("Encontrado: " + c);
        } else {
            System.out.println("No se encontró calzado con código " + codigo);
        }
    }

    private static void eliminar() {
        System.out.print("Ingresa el código a eliminar: ");
        String codigo = scanner.nextLine();
        if (!inventario.eliminarCalzado(codigo)) {
            System.out.println("No se pudo eliminar: código inexistente.");
        }
    }
}