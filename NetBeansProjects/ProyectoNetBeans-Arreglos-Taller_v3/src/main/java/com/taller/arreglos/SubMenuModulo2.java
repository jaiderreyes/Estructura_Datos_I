
package com.taller.arreglos;
import java.util.Scanner;
public class SubMenuModulo2 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Módulo 2: Matrices, Recorridos, Ordenamiento, Análisis y Objetos ---");
            System.out.println("1) Matriz básica");
            System.out.println("2) Recorridos 2D");
            System.out.println("3) Burbuja");
            System.out.println("4) Selección");
            System.out.println("5) Inserción");
            System.out.println("6) Ordenar filas de una matriz");
            System.out.println("7) Contador comparaciones/movimientos (inserción)");
            System.out.println("8) Ordenar estudiantes por nota (Comparable)");
            System.out.println("9) Ordenar estudiantes compuesto (Comparator)");
            System.out.println("10) Buscar estudiante por nombre");
            System.out.println("0) Volver");
            System.out.print("Opción: ");
            String op = sc.nextLine().trim();
            switch (op) {
                case "1": MatrizBasica.run(); break;
                case "2": Recorridos2D.run(); break;
                case "3": Burbuja.run(); break;
                case "4": Seleccion.run(); break;
                case "5": Insercion.run(); break;
                case "6": OrdenarFilasMatriz.run(); break;
                case "7": ContadorInsercion.demo(); break;
                case "8": OrdenarEstudiantes.run(); break;
                case "9": OrdenarEstudiantesComp.run(); break;
                case "10": BuscarEstudiante.run(); break;
                case "0": return;
                default: System.out.println("Opción inválida");
            }
        }
    }
}
