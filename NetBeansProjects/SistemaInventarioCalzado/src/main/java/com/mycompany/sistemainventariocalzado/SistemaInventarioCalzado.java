/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemainventariocalzado;

/**
 *
 * @author jaiderreyes
 */

import java.util.ArrayList;
import java.util.Scanner;

// Clase abstracta para definir las operaciones básicas de inventario
abstract class Inventario {
    protected ArrayList<Calzado> inventario = new ArrayList<>();

    public abstract void agregarCalzado(Calzado calzado);
    public abstract Calzado buscarCalzado(String codigo);
    public abstract void eliminarCalzado(String codigo);
}

// Clase Calzado que representa un artículo en el inventario
class Calzado {
    private String codigo;
    private String marca;
    private int talla;
    private double precio;

    public Calzado(String codigo, String marca, int talla, double precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.talla = talla;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Marca: " + marca + ", Talla: " + talla + ", Precio: $" + precio;
    }
}

// Clase InventarioCalzado que hereda de Inventario e implementa sus métodos
class InventarioCalzado extends Inventario {
    @Override
    public void agregarCalzado(Calzado calzado) {
        inventario.add(calzado);
        System.out.println("Calzado agregado: " + calzado);
    }

    @Override
    public Calzado buscarCalzado(String codigo) {
        for (Calzado calzado : inventario) {
            if (calzado.getCodigo().equals(codigo)) {
                return calzado;
            }
        }
        return null;
    }

    @Override
    public void eliminarCalzado(String codigo) {
        Calzado calzado = buscarCalzado(codigo);
        if (calzado != null) {
            inventario.remove(calzado);
            System.out.println("Calzado eliminado: " + calzado);
        } else {
            System.out.println("Calzado no encontrado.");
        }
    }
}
public class SistemaInventarioCalzado {

    public static void main(String[] args) {
        InventarioCalzado inventario = new InventarioCalzado();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Sistema de Inventario de Calzado ---");
            System.out.println("1. Agregar calzado");
            System.out.println("2. Buscar calzado");
            System.out.println("3. Eliminar calzado");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese código del calzado: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Ingrese marca del calzado: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese talla del calzado: ");
                    int talla = scanner.nextInt();
                    System.out.print("Ingrese precio del calzado: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer

                    Calzado nuevoCalzado = new Calzado(codigo, marca, talla, precio);
                    inventario.agregarCalzado(nuevoCalzado);
                    break;

                case 2:
                    System.out.print("Ingrese el código del calzado a buscar: ");
                    codigo = scanner.nextLine();
                    Calzado calzadoBuscado = inventario.buscarCalzado(codigo);
                    if (calzadoBuscado != null) {
                        System.out.println("Calzado encontrado: " + calzadoBuscado);
                    } else {
                        System.out.println("Calzado no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el código del calzado a eliminar: ");
                    codigo = scanner.nextLine();
                    inventario.eliminarCalzado(codigo);
                    break;

                case 4:
                    continuar = false;
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    
    }
}
