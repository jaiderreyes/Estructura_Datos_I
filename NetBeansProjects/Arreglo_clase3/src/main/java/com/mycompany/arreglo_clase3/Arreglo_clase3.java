/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arreglo_clase3;

/**
 *
 * @author jaiderreyes
 * Arreglos Bidimensionales
 */
public class Arreglo_clase3 {

    public static void main(String[] args) {
            
        double[][] calificaciones = {
            {3.5, 4.0, 2.8},
            {4.5, 3.8, 4.2}
        };
        
        // Acceso a la nota del estudiante 1 en materia 2
        System.out.println("Nota: " + calificaciones[0][1]);
        
        // Recorrido completo
        for(int i=0; i<calificaciones.length; i++){
            for(int j=0; j<calificaciones[i].length; j++){
                System.out.print(calificaciones[i][j] + " ");
            }
            System.out.println();
        }

    }
}
