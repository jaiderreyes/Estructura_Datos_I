/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.insertionsort;

/**
 * Clase que implementa el algoritmo de ordenamiento por inserción (Insertion Sort).
 * Este programa demuestra cómo funciona el algoritmo ordenando un array de enteros.
 * El ordenamiento por inserción es un algoritmo simple que construye el array final
 * ordenado de a un elemento a la vez.
 * 
 * @author jaiderreyes
 */
public class Insertionsort {

    public static void main(String[] args) {
        // Método principal que ejecuta el algoritmo de ordenamiento por inserción
        
        // Declaración e inicialización del array con valores desordenados
        int[] arr = {3, 1, 2, 6, 4};

        // Inicio del algoritmo de ordenamiento por inserción
        // Comienza desde el segundo elemento (índice 1) hasta el final
        for (int i = 1; i < arr.length; i++) {
            // Guardar el elemento actual que vamos a insertar en su posición correcta
            int actual = arr[i];
            // j apunta al elemento anterior al actual
            int j = i - 1;

            // Mover elementos mayores que 'actual' una posición hacia adelante
            // Esto crea espacio para insertar 'actual' en su posición correcta
            while (j >= 0 && arr[j] > actual) {
                arr[j + 1] = arr[j]; // Desplazar elemento hacia la derecha
                j--; // Moverse al elemento anterior
            }

            // Insertar 'actual' en su posición correcta
            // j + 1 es la posición donde 'actual' debe quedar
            arr[j + 1] = actual;
        }

        // Imprimir el array ordenado
        // Recorre cada elemento del array y lo muestra en pantalla
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
