/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.descuentosupermercado;
import java.util.Scanner;
/**
 *
 * @author jaiderreyes
 */
public class DescuentoSupermercado {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa el precio del producto: ");
        double precio = sc.nextDouble();

        System.out.print("Ingresa tu edad: ");
        int edad = sc.nextInt();

        double descuento = 0;

        if (edad < 12) {
            descuento = 0.15;
        } else if (edad >= 60) {
            descuento = 0.20;
        }

        double precioFinal = precio - (precio * descuento);
        System.out.println("Precio final con descuento: $" + precioFinal);
    }
}
