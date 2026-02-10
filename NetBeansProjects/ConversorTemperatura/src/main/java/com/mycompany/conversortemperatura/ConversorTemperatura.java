/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conversortemperatura;
import java.util.Scanner;
/**
 *
 * @author jaiderreyes
 */
public class ConversorTemperatura {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa la temperatura: ");
        double temperatura = scanner.nextDouble();
        
        System.out.print("¿Convertir a (F)ahrenheit o a (C)elsius? ");
        char opcion = scanner.next().toUpperCase().charAt(0);
        
        double resultado;
        
        if(opcion == 'F') {
            resultado = (temperatura * 9/5) + 32;
            System.out.println(temperatura + "°C son " + resultado + "°F");
        } else if(opcion == 'C') {
            resultado = (temperatura - 32) * 5/9;
            System.out.println(temperatura + "°F son " + resultado + "°C");
        } else {
            System.out.println("Opción no válida.");
        }
    }
    }

