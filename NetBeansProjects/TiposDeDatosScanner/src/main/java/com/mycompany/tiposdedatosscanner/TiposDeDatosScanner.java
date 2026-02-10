/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiposdedatosscanner;

import java.util.Scanner;
/**
 *
 * @author jaiderreyes
 */
public class TiposDeDatosScanner {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // 🔢 Números enteros
        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();

        System.out.print("Ingrese la población de su país: ");
        long poblacion = scanner.nextLong();

        // 🔢 Números decimales
        System.out.print("Ingrese su altura en metros: ");
        float altura = scanner.nextFloat();

        System.out.print("Ingrese el precio de un producto favorito: ");
        double precio = scanner.nextDouble();

        scanner.nextLine(); // Limpiar buffer antes de leer texto

        // 📝 Texto
        System.out.print("Ingrese la inicial de su nombre: ");
        char inicial = scanner.next().charAt(0);

        scanner.nextLine(); // Limpiar buffer antes de leer texto completo
        System.out.print("Ingrese su nombre completo: ");
        String nombre = scanner.nextLine();

        // ✅ Booleano
        System.out.print("¿Eres mayor de edad? (true/false): ");
        boolean esMayorDeEdad = scanner.nextBoolean();

        // 📌 Mostrar los valores ingresados
        System.out.println("\n--- DATOS INGRESADOS ---");
        System.out.println("Edad: " + edad);
        System.out.println("Población del país: " + poblacion);
        System.out.println("Altura: " + altura + " metros");
        System.out.println("Precio del producto: $" + precio);
        System.out.println("Inicial del nombre: " + inicial);
        System.out.println("Nombre completo: " + nombre);
        System.out.println("¿Es mayor de edad?: " + esMayorDeEdad);

        // Cerrar el Scanner (buena práctica)
        scanner.close();
    }
}
