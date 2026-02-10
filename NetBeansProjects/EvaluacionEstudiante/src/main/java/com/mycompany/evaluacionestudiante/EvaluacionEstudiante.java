/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.evaluacionestudiante;

/**
 *
 * @author jaiderreyes
 */
import java.util.Scanner;
public class EvaluacionEstudiante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double notaFinal;

        // Solicitar la nota al usuario
        System.out.print("Ingrese la nota final (rango 1.0 - 5.0): ");
        notaFinal = scanner.nextDouble();

        // Validar que la nota esté en el rango permitido
        if (notaFinal >= 1.0 && notaFinal <= 5.0) {
            // Verificar si está aprobado o reprobado
            if (notaFinal >= 4.0) {
                System.out.println("APROBADO");
            } else {
                System.out.println("REPROBADO");
            }
        } else {
            System.out.println("Error: La nota ingresada está fuera del rango permitido.");
        }
        
        //5scanner.close();
    }
}
