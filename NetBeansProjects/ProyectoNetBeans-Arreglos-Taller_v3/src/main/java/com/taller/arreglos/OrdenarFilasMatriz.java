
package com.taller.arreglos;
import java.util.Arrays;
public class OrdenarFilasMatriz {
    static void insertion(int[] a){
        for (int i=1;i<a.length;i++){
            int x=a[i], j=i-1;
            while (j>=0 && a[j]>x){ a[j+1]=a[j]; j--; }
            a[j+1]=x;
        }
    }
    public static void run() {
        int[][] m = {{3,1,4},{1,9,5,2}};
        for (int i=0;i<m.length;i++) insertion(m[i]);
        for (int[] fila : m) System.out.println(Arrays.toString(fila));
    }
}
