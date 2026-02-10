package com.mycompany.colasejemplos;

import java.util.ArrayDeque;
import java.util.Queue;

public class ColaConArrayDeque {
    public static void main(String[] args) {
        Queue<Integer> cola = new ArrayDeque<>();

        // Encolar
        cola.add(10);
        cola.add(20);
        cola.add(30);
        System.out.println("Cola inicial: " + cola);

        // Peek
        System.out.println("Frente actual: " + cola.peek());

        // Desencolar
        cola.remove();
        System.out.println("Después de desencolar: " + cola);

        // Verificar si está vacía
        System.out.println("¿La cola está vacía?: " + cola.isEmpty());

        // Agregar más elementos
        cola.add(40);
        cola.add(50);
        System.out.println("Cola final: " + cola);
    }
}
