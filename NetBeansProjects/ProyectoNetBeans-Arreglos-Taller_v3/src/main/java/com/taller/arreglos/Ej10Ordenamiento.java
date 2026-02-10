
package com.taller.arreglos;
import java.util.Arrays;
public class Ej10Ordenamiento {
    public static void run() {
        int[] a = {5,1,4,2,3};
        System.out.println("Inicio: " + Arrays.toString(a));
        int movimientos = 0;
        for (int i=1;i<a.length;i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j+1] = a[j]; j--; movimientos++;
                System.out.println("Paso: " + Arrays.toString(a));
            }
            a[j+1] = key;
            System.out.println("Inserta " + key + " -> " + Arrays.toString(a));
        }
        System.out.println("Total movimientos: " + movimientos);
        int[] b = {5,1,4,2,3};
        int swaps = 0;
        for (int i=0;i<b.length-1;i++) {
            int min=i;
            for (int j=i+1;j<b.length;j++) if (b[j] < b[min]) min=j;
            if (min != i) { int t=b[i]; b[i]=b[min]; b[min]=t; swaps++; }
        }
        System.out.println("Selección: " + Arrays.toString(b) + " | swaps=" + swaps);
    }
}
