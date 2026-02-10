/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numeroprimo;
import java.util.Scanner;
/**
 *
 * @author jaiderreyes
 */
public class NumeroPrimo {

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa un número entero: ");
        int numero = scanner.nextInt();
        
        if (esPrimo(numero)) {
            System.out.println(numero + " es un número primo.");
        } else {
            System.out.println(numero + " no es un número primo.");
        }
    }
    
    public static boolean esPrimo(int num) {
        if(num <= 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
}
}