/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conversionmoneda;
import java.util.Scanner;

/**
 *
 * @author jaiderreyes
 */
public class ConversionMoneda {

    public static void main(String[] args) {
       double TASA_DE_CAMBIO = 4.000; // Fijamos la tasa de conversión
     Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad en dólares: ");
        double dolares = scanner.nextDouble();
        
        double pesos = dolares * TASA_DE_CAMBIO;

        System.out.println(dolares + " dólares equivalen a " + pesos + " pesos colombianos.");
    }
}
