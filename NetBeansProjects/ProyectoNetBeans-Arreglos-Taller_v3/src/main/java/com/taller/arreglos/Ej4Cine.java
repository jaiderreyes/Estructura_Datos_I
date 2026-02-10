
package com.taller.arreglos;
import java.util.Scanner;
public class Ej4Cine {
    public static void run() {
        int[] sillas = {1,0,0,1,0,0,0,1,0,1};
        System.out.print("Libres en posiciones: ");
        for (int i = 0; i < sillas.length; i++) if (sillas[i] == 0) System.out.print(i + " ");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese asiento a reservar (0..9): ");
        int k = -1;
        try { k = Integer.parseInt(sc.nextLine()); } catch (Exception e) { k = -1; }
        if (k >= 0 && k < sillas.length && sillas[k] == 0) { sillas[k] = 1; System.out.println("Reservado " + k); }
        else System.out.println("No disponible.");
        int best=0, cur=0;
        for (int v : sillas) { if (v==0) {cur++; best=Math.max(best,cur);} else cur=0; }
        System.out.println("Bloque contiguo libre más largo: " + best);
    }
}
