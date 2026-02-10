/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.adivinanumerodowhile;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author jaiderreyes
 */
public class AdivinaNumeroDoWhile {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1; // Número aleatorio entre 1 y 100
        int intento;
        int intentos = 0;
        
        System.out.println("Adivina el número secreto (entre 1 y 100):");
        do {
            System.out.print("Ingresa tu intento: ");
            intento = sc.nextInt();
            intentos++;
            
            if (intento < numeroSecreto) {
                System.out.println("Muy bajo. Intenta de nuevo.");
            } else if (intento > numeroSecreto) {
                System.out.println("Muy alto. Intenta de nuevo.");
            } else {
                System.out.println("¡Felicidades! Adivinaste el número en " + intentos + " intentos.");
            }
        } while (intento != numeroSecreto);
    }
}
