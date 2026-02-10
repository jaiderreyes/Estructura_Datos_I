/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.seleccionsort;

/**
 *
 * @author jaiderreyes
 */
public class Seleccionsort {
    /**
     * Método principal que implementa el algoritmo de Selection Sort
     * El Selection Sort funciona seleccionando el elemento más pequeño del arreglo
     * y colocándolo en su posición correcta
     */
    public static void main(String[] args) {
        
        // PASO 1: Declarar e inicializar el arreglo a ordenar
        int[] arr = {5, 3, 1, 4, 2};
        // Estado inicial: [5, 3, 1, 4, 2]

        // PASO 2: Algoritmo de Selection Sort
        // Bucle externo: recorre cada posición del arreglo excepto la última
        for (int i = 0; i < arr.length - 1; i++) {
            // PASO 2.1: Asumir que el elemento actual es el mínimo
            int min = i; // índice del elemento más pequeño encontrado
            
            // PASO 2.2: Buscar el elemento más pequeño en el resto del arreglo
            // Bucle interno: busca el mínimo desde i+1 hasta el final
            for (int j = i + 1; j < arr.length; j++) {
                // Si encontramos un elemento más pequeño que el actual mínimo
                if (arr[j] < arr[min]) {
                    min = j; // actualizamos el índice del mínimo
                }
            }
            
            // PASO 2.3: Intercambiar el elemento actual con el mínimo encontrado
            // Usamos una variable temporal para el intercambio
            int temp = arr[i];    // guardamos el elemento actual
            arr[i] = arr[min];    // colocamos el mínimo en la posición actual
            arr[min] = temp;      // movemos el elemento actual a la posición del mínimo
        }

        // PASO 3: Imprimir el arreglo ordenado
        // Usamos un bucle for-each para recorrer e imprimir cada elemento
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Resultado esperado: 1 2 3 4 5
    }
}


        