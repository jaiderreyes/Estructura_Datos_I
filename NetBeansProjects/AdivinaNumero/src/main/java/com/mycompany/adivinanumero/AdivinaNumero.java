/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.adivinanumero;

/**
 *
 * @author jaiderreyes
 */

import java.util.Scanner;

public class AdivinaNumero {

    public static void main(String[] args) {
        int numeroSecreto = 7; 
        

// Número a adivinar
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Adivina el número entre 1 y 10: ");
        
        int intento = scanner.nextInt();

System.out.println(intento);
        if (intento == numeroSecreto) {
            System.out.println("🎉 ¡Felicidades! Adivinaste el número.");
        } else if (intento > numeroSecreto) {
            System.out.println("📉 El número es menor. ¡Inténtalo de nuevo!");
        } else {
            System.out.println("📈 El número es mayor. ¡Sigue intentando!");
        }
    }
}
