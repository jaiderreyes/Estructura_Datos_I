
package com.taller.arreglos;
import java.util.Arrays;
import java.util.Scanner;
public class Ej5Kiosko {
    public static void run() {
        String[] prod = {"Jugo","Galleta","Sandwich"};
        int[] stock = {5,2,1};
        System.out.println("Inventario:");
        for (int i=0;i<prod.length;i++) System.out.println(prod[i]+": "+stock[i]);
        Scanner sc = new Scanner(System.in);
        System.out.print("Producto a vender: ");
        String p = sc.nextLine().trim();
        int idx = -1;
        for (int i=0;i<prod.length;i++) if (prod[i].equalsIgnoreCase(p)) { idx = i; break; }
        if (idx==-1) System.out.println("No existe.");
        else if (stock[idx] > 0) { stock[idx]--; System.out.println("Vendido. Nuevo stock="+stock[idx]); }
        else System.out.println("Agotado.");
        for (int i=0;i<stock.length-1;i++) {
            int min=i;
            for (int j=i+1;j<stock.length;j++) if (stock[j] < stock[min]) min=j;
            int ts = stock[i]; stock[i]=stock[min]; stock[min]=ts;
            String tp = prod[i]; prod[i]=prod[min]; prod[min]=tp;
        }
        System.out.println("Reordenado por stock asc:");
        System.out.println(Arrays.toString(prod) + " " + Arrays.toString(stock));
    }
}
