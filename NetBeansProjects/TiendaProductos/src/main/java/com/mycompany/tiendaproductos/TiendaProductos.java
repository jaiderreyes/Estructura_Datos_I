/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendaproductos;
import java.util.Scanner;
/**
 *
 * @author jaiderreyes
 */
public class TiendaProductos {

    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);

        // Solicitar el nombre del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = input.nextLine();

        // Mostrar menú de productos
        System.out.println("\n===== MENÚ DE PRODUCTOS =====");
        System.out.println("1. Celular ($500 c/u) - Descuento del 5% si compras más de 5.");
        System.out.println("2. Laptop ($1200 c/u) - Descuento del 10% si compras más de 3.");
        System.out.println("3. Tablet ($750 c/u) - Descuento del 7% si compras más de 4.");
        System.out.print("Seleccione el número del producto a comprar: ");
        int opcion = input.nextInt();
  // Solicitar cantidad de unidades
     String producto = "";
        System.out.print("Ingrese la cantidad de " + producto + "s a comprar: ");
        // Definir variables
      
        double precioUnitario = 0;
        double descuento = 0;

        // Validar opción seleccionada
        
        int cantidad = input.nextInt();
        switch (opcion) {
            case 1:
              
                producto = "Celular";
                precioUnitario = 500;
               //descuento = 0.05; // 5% para Celulares si > 5 unidades
                break;
            case 2:
                
                producto = "Laptop";
                //descuento = 0.10; // 10% para Laptops si > 3 unidades
                precioUnitario = 1200;
                break;
            case 3:
               
                producto = "Tablet";
                //descuento = 0.07; // 7% para Tablets si > 4 unidades
                precioUnitario = 750;
                break;
            default:
                System.out.println("Opción inválida. Saliendo del programa...");
                return;
        }

      
  
        // Aplicar descuentos según el producto seleccionado
      if (opcion == 1 && cantidad > 5) {
            descuento = 0.05; // 5% para Celulares si > 5 unidades
        } else if (opcion == 2 && cantidad > 3) {
            descuento = 0.10; // 10% para Laptops si > 3 unidades
        } else if (opcion == 3 && cantidad > 4) {
            descuento = 0.07; // 7% para Tablets si > 4 unidades
        }

        // Calcular total
        double subtotal = cantidad * precioUnitario;
        double montoDescuento = subtotal * descuento;
        double totalPagar = subtotal - montoDescuento;

        // Mostrar factura
        System.out.println("\n===== FACTURA =====");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Producto: " + producto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: $" + precioUnitario);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento aplicado: " + (descuento * 100) + "% ($" + montoDescuento + ")");
        System.out.println("Total a pagar: $" + totalPagar);
    }
}
