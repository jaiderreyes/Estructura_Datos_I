
package com.taller.arreglos;
public class Ej3Votacion {
    public static void run() {
        int[] votos = {1,0,2,1,2,2,0,1};
        int[] conteo = new int[3];
        for (int v : votos) conteo[v]++;
        String[] nombres = {"Java","Python","JS"};
        int ganador = 0;
        for (int i = 1; i < conteo.length; i++) if (conteo[i] > conteo[ganador]) ganador = i;
        System.out.printf("Java=%d Python=%d JS=%d\n", conteo[0], conteo[1], conteo[2]);
        if ((conteo[ganador] == conteo[(ganador+1)%3]) || (conteo[ganador] == conteo[(ganador+2)%3]))
            System.out.println("Empate -> segunda vuelta.");
        else
            System.out.println("Ganador: " + nombres[ganador]);
    }
}
