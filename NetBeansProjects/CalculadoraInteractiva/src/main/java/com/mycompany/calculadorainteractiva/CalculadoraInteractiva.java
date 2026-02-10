/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadorainteractiva;
import java.util.Scanner;
/**
 *
 * @author jaiderreyes
 */
public class CalculadoraInteractiva {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int contadorEstudiantes = 0;
        double sumaNotas = 0.0;

        do {
            System.out.println("\n=== Sistema de Registro de Notas ===");
            System.out.println("1. Registrar estudiante y nota");
            System.out.println("2. Mostrar cantidad de estudiantes registrados");
            System.out.println("3. Calcular promedio de notas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine(); // limpiar buffer
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese la calificación (0.0 a 5.0): ");
                    double nota = scanner.nextDouble();

                    if (nota >= 0.0 && nota <= 5.0) {
                        contadorEstudiantes++;
                        sumaNotas += nota;
                        System.out.println("Estudiante " + nombre + " registrado con nota " + nota);
                    } else {
                        System.out.println("¡Nota inválida! Debe estar entre 0.0 y 5.0.");
                    }
                    break;

                case 2:
                    System.out.println("Estudiantes registrados: " + contadorEstudiantes);
                    break;

                case 3:
                    if (contadorEstudiantes > 0) {
                        double promedio = sumaNotas / contadorEstudiantes;
                        System.out.printf("Promedio general de notas: %.2f\n", promedio);
                    } else {
                        System.out.println("Aún no hay estudiantes registrados.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema... ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
                    break;
            }

        } while (opcion != 4);
    }
}
