
package com.taller.arreglos;
import java.util.Arrays;
public class ContadorInsercion {
    static int comps=0, moves=0;
    static void insertion(int[] a){
        comps = moves = 0;
        for(int i=1;i<a.length;i++){
            int key=a[i]; int j=i-1;
            while(j>=0){ comps++; if (!(a[j] > key)) break; a[j+1]=a[j]; j--; moves++; }
            a[j+1]=key; moves++;
        }
    }
    public static void demo() {
        int[] a = {5,1,4,2,8};
        insertion(a);
        System.out.println("Inserción -> " + Arrays.toString(a));
        System.out.println("Comparaciones=" + comps + " Movimientos=" + moves);
    }
}
