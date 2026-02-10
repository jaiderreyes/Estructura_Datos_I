
package com.taller.arreglos;
import java.util.Arrays;
public class Seleccion {
    public static void selection(int[] a){
        for (int i=0;i<a.length-1;i++){
            int min=i;
            for (int j=i+1;j<a.length;j++) if (a[j] < a[min]) min=j;
            int t=a[i]; a[i]=a[min]; a[min]=t;
        }
    }
    public static void run() {
        int[] a = {5,1,4,2,8};
        selection(a);
        System.out.println("Selección -> " + Arrays.toString(a));
    }
}
