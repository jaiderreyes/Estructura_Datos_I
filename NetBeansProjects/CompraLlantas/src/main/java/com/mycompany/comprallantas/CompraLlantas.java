/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.comprallantas;
import java.util.Scanner;

/**
 *
 * @author jaiderreyes
 */
public class CompraLlantas {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Solicitar nombre del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = input.nextLine();

        // Solicitar cantidad de llantas a comprar
        System.out.print("Ingrese la cantidad de llantas a comprar: ");
        int cantidadLlantas = input.nextInt();

        // Definición de variables
        double precioPorLlanta;
        double descuento;
        double totalSinDescuento;
        double totalConDescuento;

        // Aplicar condiciones de precio y descuento
        if (cantidadLlantas < 12) {
            precioPorLlanta = 250; // Precio normal
            descuento = 0.20; // 20% de descuento
        } else {
            precioPorLlanta = 220; // Precio con descuento por volumen
            descuento = 0.25; // 25% de descuento
        }

        // Calcular totales
        totalSinDescuento = cantidadLlantas * precioPorLlanta;
        totalConDescuento = totalSinDescuento - (totalSinDescuento * descuento);

        // Mostrar resultados
        System.out.println("\n===== FACTURA =====");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Cantidad de llantas: " + cantidadLlantas);
        System.out.println("Precio unitario: $" + precioPorLlanta);
        System.out.println("Subtotal: $" + totalSinDescuento);
        System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
        System.out.println("Total a pagar: $" + totalConDescuento);
    }
}
