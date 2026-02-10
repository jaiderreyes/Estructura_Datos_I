
package com.taller.arreglos;
import java.util.Scanner;
public class Ej7Bingo {
    public static void run() {
        int[] carton = {3,7,13,21,34};
        Scanner sc = new Scanner(System.in);
        System.out.print("Número sorteado: ");
        int n;
        try { n = Integer.parseInt(sc.nextLine().trim()); }
        catch (Exception e) { System.out.println("Entrada inválida."); return; }
        int idx = -1;
        for (int i=0;i<carton.length;i++) if (carton[i]==n) { idx=i; break; }
        if (idx>=0) System.out.println("¡Acierto! Índice "+idx);
        else System.out.println("No está.");
    }
}
