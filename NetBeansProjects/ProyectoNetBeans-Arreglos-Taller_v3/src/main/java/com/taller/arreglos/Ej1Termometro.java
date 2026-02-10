
package com.taller.arreglos;
public class Ej1Termometro {
    public static void run() {
        double[] temps = {28.1, 29.3, 30.0, 27.8, 28.9};
        double sum = 0; int posMin = 0, posMax = 0;
        for (int i = 0; i < temps.length; i++) {
            sum += temps[i];
            if (temps[i] < temps[posMin]) posMin = i;
            if (temps[i] > temps[posMax]) posMax = i;
        }
        double prom = sum / temps.length;
        int countHigh = 0, firstHigh = -1;
        for (int i = 0; i < temps.length; i++) {
            if (temps[i] > 29.0) { countHigh++; if (firstHigh == -1) firstHigh = i; }
        }
        System.out.printf("Promedio: %.2f\n", prom);
        System.out.printf("Min: %.2f en i=%d\n", temps[posMin], posMin);
        System.out.printf("Max: %.2f en i=%d\n", temps[posMax], posMax);
        System.out.println(">29.0: " + countHigh + " | Primer índice: " + firstHigh);
    }
}
