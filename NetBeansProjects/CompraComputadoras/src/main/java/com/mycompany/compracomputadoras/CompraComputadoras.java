/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.compracomputadoras;
import java.util.Scanner;
/**
 *
 * @author jaiderreyes
 */
public class CompraComputadoras {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

        // Solicitar el nombre del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = input.nextLine();

        // Solicitar cantidad de computadoras a comprar
        System.out.print("Ingrese la cantidad de computadoras a comprar: ");
        int cantidadComputadoras = input.nextInt();

        // Definir variables
        double precioPorComputadora;
        double descuento;
        double totalSinDescuento;
        double totalConDescuento;

        // Aplicar lógica de descuento
        if (cantidadComputadoras < 5) {
            precioPorComputadora = 800; // Precio normal
            descuento = 0.10; // 10% de descuento
        } else if (cantidadComputadoras <= 10) {
            precioPorComputadora = 800; // Precio normal
            descuento = 0.15; // 15% de descuento
        } else {
            precioPorComputadora = 750; // Precio con descuento por volumen
            descuento = 0.20; // 20% de descuento
        }

        // Calcular totales
        totalSinDescuento = cantidadComputadoras * precioPorComputadora;
        totalConDescuento = totalSinDescuento - (totalSinDescuento * descuento);

        // Mostrar factura
        System.out.println("\n===== FACTURA =====");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Cantidad de computadoras: " + cantidadComputadoras);
        System.out.println("Precio unitario: $" + precioPorComputadora);
        System.out.println("Subtotal: $" + totalSinDescuento);
        System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
        System.out.println("Total a pagar: $" + totalConDescuento);
    }
}
