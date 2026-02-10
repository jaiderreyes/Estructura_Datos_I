
package com.taller.arreglos;
import java.util.Arrays;
public class Burbuja {
    public static void bubble(int[] a){
        boolean swap;
        for (int i = 0; i < a.length - 1; i++) {
            swap = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j+1]) { int t=a[j]; a[j]=a[j+1]; a[j+1]=t; swap=true; }
            }
            if (!swap) break;
        }
    }
    public static void run() {
        int[] a = {5,1,4,2,8};
        bubble(a);
        System.out.println("Burbuja -> " + Arrays.toString(a));
    }
}
