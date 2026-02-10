/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arreglos5_practice;
import java.util.Arrays;

/**
 *
 * @author jaiderreyes
 */
public class Arreglos5_practice {

    public static void main(String[] args) {
        int arr[] = {3,5,5,7,9};
        Integer arrr [] = {3,5,5,7,9};
 
       System.out.println(Arrays.toString(arr));

 // Permite acceder al índice, útil para posiciones. For clásico (con índices)    
    for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + " ");
}
System.out.println();


// For-each (enhanced for) ideal para recorrer sin preocuparse de los índices.
for (int num : arr) {
    System.out.print(num + " ");
}
System.out.println();

//Arrays.stream()

Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
System.out.println();


//Impresión manual con while, Buena práctica para recordar que no siempre se usa for.

int j = 0;
while (j < arr.length) {
    System.out.print(arr[j] + " ");
    j++;
}
System.out.println();

//Si cambias int[] arr = {3,5,5,7,9}; por Integer[] arrr = {...}, puedes imprimir con facilidad como lista.
System.out.println(Arrays.asList(arrr)); // Ojo: solo funciona con Integer[], no int[]

//Formato tipo tabla, Más “amigable” para visualizar en forma estructurada.
for (int i = 0; i < arr.length; i++) {
    System.out.printf("Posición %d → %d\n", i, arr[i]);
}



    }
}
