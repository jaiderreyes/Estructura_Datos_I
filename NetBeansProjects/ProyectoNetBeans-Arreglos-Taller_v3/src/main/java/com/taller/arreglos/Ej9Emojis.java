
package com.taller.arreglos;
public class Ej9Emojis {
    public static void run() {
        String[] emojis = {"😀","🔥","🔥","💡","😀","😀"};
        String[] valor = new String[emojis.length];
        int[] conteo = new int[emojis.length];
        int k = 0;
        outer: for (String e : emojis) {
            for (int i=0;i<k;i++) {
                if (valor[i].equals(e)) { conteo[i]++; continue outer; }
            }
            valor[k] = e; conteo[k] = 1; k++;
        }
        for (int i=0;i<k-1;i++) {
            int max=i;
            for (int j=i+1;j<k;j++) if (conteo[j] > conteo[max]) max=j;
            int tc = conteo[i]; conteo[i]=conteo[max]; conteo[max]=tc;
            String tv = valor[i]; valor[i]=valor[max]; valor[max]=tv;
        }
        for (int i=0;i<k;i++) System.out.println(valor[i] + " -> " + conteo[i]);
    }
}
