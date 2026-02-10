/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiposdedatos;

/**
 *
 * @author jaiderreyes
 */
public class TiposDeDatos {

    public static void main(String[] args) {
         // 📌 Tipos de datos en Java

        // 🔢 Números enteros
        int edad = 25;  // Número entero
        long poblacionMundial = 8000000000L;  // Número grande

        // 🔢 Números decimales
        float altura = 1.75f;  // Menos preciso
        double precio = 199.99; // Más preciso

        // 📝 Texto (Cadenas de caracteres)
        char inicial = 'J';  // Solo un carácter
        String nombre = "Juan Pérez"; // Texto completo

        // ✅ Booleanos (Verdadero/Falso)
        boolean esMayorDeEdad = true;
        boolean tieneLicencia = false;

        // 📌 Imprimir los valores en pantalla
        System.out.println("Edad: " + edad);
        System.out.println("Población Mundial: " + poblacionMundial);
        System.out.println("Altura: " + altura + " metros");
        System.out.println("Precio del producto: $" + precio);
        System.out.println("Inicial del nombre: " + inicial);
        System.out.println("Nombre completo: " + nombre);
        System.out.println("¿Es mayor de edad?: " + esMayorDeEdad);
        System.out.println("¿Tiene licencia de conducir?: " + tieneLicencia);
    
    }
}
