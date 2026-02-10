/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bublesort;

/**
 * Clase que implementa el algoritmo de ordenamiento Bubble Sort
 * Esta clase demuestra el funcionamiento básico del algoritmo de burbuja
 * para ordenar un array de enteros en orden ascendente.
 * 
 * @author jaiderreyes
 */
public class Bublesort {

    /**
     * Método principal que ejecuta el programa
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Declaración e inicialización del array de enteros a ordenar
        // Contiene los valores: 4, 2, 1, 3 (desordenado)
        int[] arr = {4, 2, 1, 3};

        // Bucle externo: controla el número de pasadas completas
        // Se ejecuta n-1 veces (donde n es la longitud del array)
        // En cada pasada, el elemento más grande "burbujea" hacia el final
        for (int i = 0; i < arr.length - 1; i++) {
            // Bucle interno: realiza las comparaciones e intercambios
            // Compara cada elemento con su siguiente elemento
            // j va desde 0 hasta n-2 (penúltimo elemento)
            for (int j = 0; j < arr.length - 1; j++) {
                // Condición: si el elemento actual es mayor que el siguiente
                // Si es verdadero, los elementos están en orden incorrecto y necesitan intercambio
                if (arr[j] > arr[j + 1]) {
                    // Inicio del proceso de intercambio (swap)
                    // Se usa una variable temporal para guardar el valor actual
                    
                    // Variable temporal que almacena el valor del elemento actual (arr[j])
                    int temp = arr[j];
                    
                    // El elemento actual recibe el valor del elemento siguiente
                    // Ahora arr[j] contiene el valor menor
                    arr[j] = arr[j + 1];
                    
                    // El elemento siguiente recibe el valor guardado en temp
                    // Ahora arr[j+1] contiene el valor mayor
                    arr[j + 1] = temp;
                    // Fin del intercambio: los dos elementos han intercambiado sus posiciones
                }
            }
            // Fin de una pasada completa: el elemento más grande está ahora en su posición correcta
        }
        // Fin de todas las pasadas: el array está completamente ordenado

        // Bucle for-each para imprimir el array ordenado
        // Recorre cada elemento del array ya ordenado
        for (int n : arr) {
            // Imprime cada elemento seguido de un espacio
            // Usamos print() en lugar de println() para mantener todo en una línea
            System.out.print(n + " ");
        }
        // Salida esperada: "1 2 3 4 "
    }
}
