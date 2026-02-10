/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arreglo_ejemplo4mayormenor;

/**
 *
 * @author jaiderreyes
 */
public class Arreglo_ejemplo4mayormenor {

    public static void main(String[] args) {
        double[] notas = {3.5, 4.0, 2.8, 5.0, 3.8};

        int posMin = 0, posMax = 0;
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < notas[posMin]) posMin = i;
            if (notas[i] > notas[posMax]) posMax = i;
        }
        System.out.println("Min="+notas[posMin]+" en i="+posMin);
        System.out.println("Max="+notas[posMax]+" en i="+posMax);

        // Búsqueda lineal de un valor
        double objetivo = 4.0;
        int pos = -1;
        for (int i = 0; i < notas.length; i++) if (notas[i] == objetivo) { pos = i; break; }
        System.out.println("4.0 encontrado en i="+pos);

    }
}
