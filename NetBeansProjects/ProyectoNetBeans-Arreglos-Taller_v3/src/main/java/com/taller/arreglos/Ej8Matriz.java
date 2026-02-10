
package com.taller.arreglos;
public class Ej8Matriz {
    public static void run() {
        double[][] notas = {{4.0,3.5,4.2},{3.8,4.5,4.1}};
        for (int i=0;i<notas.length;i++) {
            for (int j=0;j<notas[i].length;j++) System.out.print(notas[i][j] + "\t");
            System.out.println();
        }
        for (int i=0;i<notas.length;i++) {
            double suma = 0; for (double x : notas[i]) suma += x;
            System.out.printf("Promedio estudiante %d: %.2f\n", i, suma/notas[i].length);
        }
        for (int j=0;j<notas[0].length;j++) {
            double suma = 0; for (int i=0;i<notas.length;i++) suma += notas[i][j];
            System.out.printf("Promedio materia %d: %.2f\n", j, suma/notas.length);
        }
        int best = 0; double bestProm = -1;
        for (int i=0;i<notas.length;i++) {
            double suma = 0; for (double x : notas[i]) suma += x;
            double p = suma / notas[i].length;
            if (p > bestProm) { bestProm = p; best = i; }
        }
        System.out.printf("Mejor estudiante: %d con %.2f\n", best, bestProm);
    }
}
