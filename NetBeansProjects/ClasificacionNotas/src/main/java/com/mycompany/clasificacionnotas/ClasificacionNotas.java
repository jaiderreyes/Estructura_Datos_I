/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clasificacionnotas;
import java.util.Scanner;
/**
 *
 * @author jaiderreyes
 */
public class ClasificacionNotas {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        int totalEstudiantes;
        int i = 1;
        int excelentes = 0, buenas = 0, regulares = 0, insuficientes = 0;

        System.out.print("¿Cuántos estudiantes vas a calificar? ");
        totalEstudiantes = scanner.nextInt();

        while (i <= totalEstudiantes) {
            System.out.print("Ingresa la calificación del estudiante #" + i + ": ");
            double nota = scanner.nextDouble();

            if (nota >= 4.5 && nota <= 5.0) {
                System.out.println("Clasificación: Excelente");
                excelentes++;
            } else if (nota >= 3.5 && nota < 4.5) {
                System.out.println("Clasificación: Buena");
                buenas++;
            } else if (nota >= 3.0 && nota < 3.5) {
                System.out.println("Clasificación: Regular");
                regulares++;
            } else if (nota < 3.0 && nota >= 0.0) {
                System.out.println("Clasificación: Insuficiente");
                insuficientes++;
            } else {
                System.out.println("Nota no válida. Debe estar entre 0.0 y 5.0");
                continue; // no avanza si la nota no es válida
            }

            i++;
        }

        // Resumen final
        System.out.println("\n--- Resumen ---");
        System.out.println("Excelentes: " + excelentes);
        System.out.println("Buenas: " + buenas);
        System.out.println("Regulares: " + regulares);
        System.out.println("Insuficientes: " + insuficientes);
    }
}
