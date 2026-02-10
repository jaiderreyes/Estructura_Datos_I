/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sumarnumeroswhile;
import java.util.Scanner;
/**
 *
 * @author jaiderreyes
 */
public class SumarNumerosWhile {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int suma = 0;
        int numero;
        
        System.out.println("Ingrese números para sumar (ingrese un número negativo para terminar):");
        numero = sc.nextInt();
        while (numero >= 0) {
            suma += numero;
            numero = sc.nextInt();
        }
        System.out.println("La suma es: " + suma);
    }
}
