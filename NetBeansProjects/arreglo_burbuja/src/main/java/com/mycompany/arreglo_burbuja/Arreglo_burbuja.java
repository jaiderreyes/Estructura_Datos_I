/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arreglo_burbuja;

import java.util.Arrays;

   

/**
 *
 * @author jaiderreyes
 */
public class Arreglo_burbuja {
 public static void bubbleSort(double[] a) {
        boolean swapped;
        for (int i = 0; i < a.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) { double t = a[j]; a[j] = a[j+1]; a[j+1] = t; swapped = true; }
            }
            if (!swapped) break; // pequeña optimización
        }
    }
    public static void main(String[] args) {
        double[] notas = {3.5, 4.0, 2.8, 5.0, 3.8};
        bubbleSort(notas);
        System.out.println(Arrays.toString(notas));

    }
}
