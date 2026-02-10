/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.linkedlist;
import java.util.LinkedList;


/**
 *
 * @author jaiderreyes
 */
public class LinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> numeros = new LinkedList<>();

        numeros.add(10);// Insertar el 10
        numeros.add(20);// Insertar el numero 20
        numeros.addFirst(5);  // Insertar al inicio
        numeros.addLast(30);  // Insertar al final

        System.out.println("Lista enlazada: " + numeros);

        numeros.removeFirst(); // Eliminar el primero
        numeros.removeLast();  // Eliminar el último

        System.out.println("Después de eliminar: " + numeros);
    }
}
