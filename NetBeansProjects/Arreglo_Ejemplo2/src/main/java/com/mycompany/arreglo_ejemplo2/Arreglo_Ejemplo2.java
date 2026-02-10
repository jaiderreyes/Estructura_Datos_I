/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arreglo_ejemplo2;

/**
 *
 * @author jaiderreyes
 */
public class Arreglo_Ejemplo2 {

    public static void main(String[] args) {
        double[] notas = {3.5, 4.0, 2.8, 5.0};
        
        for(int i=0; i<notas.length; i++){
            System.out.println("Nota " + (i+1) + ": " + notas[i]);
        }
        
        double suma = 0;
        for(double n : notas){
            suma += n;
        }
        double promedio = suma / notas.length;
        System.out.println("Promedio: " + promedio);
    }
}
