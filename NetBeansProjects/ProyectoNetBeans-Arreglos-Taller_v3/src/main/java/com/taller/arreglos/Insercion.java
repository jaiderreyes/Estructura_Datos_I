
package com.taller.arreglos;
import java.util.Arrays;
public class Insercion {
    public static void insertion(int[] a){
        for (int i=1;i<a.length;i++){
            int key=a[i], j=i-1;
            while (j>=0 && a[j]>key){ a[j+1]=a[j]; j--; }
            a[j+1]=key;
        }
    }
    public static void run() {
        int[] a = {5,1,4,2,8};
        insertion(a);
        System.out.println("Inserción -> " + Arrays.toString(a));
    }
}
