/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fibonaccifor;

/**
 *
 * @author jaiderreyes
 */
import java.util.Scanner;
public class FibonacciFor {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de números de Fibonacci a mostrar: ");
        int n = sc.nextInt();
        
        int a = 0, b = 1;
        System.out.print("Serie Fibonacci: " + a + " " + b + " ");
        
        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
