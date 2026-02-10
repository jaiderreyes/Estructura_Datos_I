
package com.taller.arreglos;
public class Recorridos2D {
    public static void run() {
        int[][] m = {{3,1,4},{1,5,9}};
        System.out.println("for por índices:");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) System.out.print(m[i][j] + " ");
            System.out.println();
        }
        System.out.println("for-each:");
        for (int[] fila : m) {
            for (int v : fila) System.out.print(v + " ");
            System.out.println();
        }
        for (int i = 0; i < m.length; i++) {
            int sumaFila = 0;
            for (int v : m[i]) sumaFila += v;
            System.out.println("suma fila " + i + " = " + sumaFila);
        }
        for (int j = 0; j < m[0].length; j++) {
            int sumaCol = 0;
            for (int i = 0; i < m.length; i++) sumaCol += m[i][j];
            System.out.println("suma col " + j + " = " + sumaCol);
        }
    }
}
