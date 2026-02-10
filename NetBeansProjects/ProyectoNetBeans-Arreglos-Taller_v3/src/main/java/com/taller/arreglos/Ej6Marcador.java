
package com.taller.arreglos;
public class Ej6Marcador {
    public static void run() {
        int[] goles = {0,1,0,2,1,0};
        int total=0; for (int g : goles) total += g;
        double prom = (double) total / goles.length;
        int racha=0, mejor=0, partidoMax=0;
        for (int i=0;i<goles.length;i++) {
            if (goles[i]==0) { racha++; if (racha>mejor) mejor=racha; }
            else racha=0;
            if (goles[i] > goles[partidoMax]) partidoMax = i;
        }
        System.out.println("Total goles: "+total+" | Promedio: "+prom);
        System.out.println("Racha sin goles más larga: "+mejor);
        System.out.println("Partido con más goles: índice "+partidoMax+" (g="+goles[partidoMax]+")");
    }
}
