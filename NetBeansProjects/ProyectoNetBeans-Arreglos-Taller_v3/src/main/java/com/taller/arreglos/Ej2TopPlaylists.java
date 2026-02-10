
package com.taller.arreglos;
import java.util.Arrays;
public class Ej2TopPlaylists {
    public static void run() {
        int[] plays = {120, 450, 230, 980, 540, 320};
        int comps = 0; boolean swap;
        for (int i = 0; i < plays.length - 1; i++) {
            swap = false;
            for (int j = 0; j < plays.length - 1 - i; j++) {
                comps++;
                if (plays[j] > plays[j+1]) {
                    int t = plays[j]; plays[j] = plays[j+1]; plays[j+1] = t; swap = true;
                }
            }
            if (!swap) break;
        }
        System.out.println("Ordenado asc: " + Arrays.toString(plays));
        int n = plays.length;
        System.out.println("Top1=" + plays[n-1] + " Top2=" + plays[n-2] + " Top3=" + plays[n-3]);
        System.out.println("Comparaciones burbuja: " + comps);
    }
}
