/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arreglos_ejemplo3_patronrecorrido;

/**
 *
 * @author jaiderreyes
 */
public class Arreglos_ejemplo3_patronrecorrido {

    public static void main(String[] args) {
            double[] notas = {3.5, 4.0, 2.8, 5.0};

        // For indexado
        for (int i = 0; i < notas.length; i++) System.out.println("i="+i+" nota="+notas[i]);

        // For-each
        for (double n : notas) System.out.println("nota="+n);

        // Acumulado + conteo
        double suma = 0;
        for (double n : notas) suma += n;
        System.out.println("Promedio = " + (suma / notas.length));
    }
}
