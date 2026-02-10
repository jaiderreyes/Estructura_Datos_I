package com.mycompany.colasejemplos;

public class ColaCircularArray {
    private final int[] cola;
    private int front;
    private int rear;
    private int size;

    // Constructor
    public ColaCircularArray(int capacidad) {
        cola = new int[capacidad];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Encolar
    public void encolar(int elemento) {
        if (size == cola.length) {
            System.out.println("Cola llena. No se puede encolar.");
            return;
        }
        rear = (rear + 1) % cola.length;
        cola[rear] = elemento;
        size++;
        System.out.println("Encolado: " + elemento);
    }

    // Desencolar
    public int desencolar() {
        if (isEmpty()) {
            System.out.println("Cola vacía. No se puede desencolar.");
            return -1;
        }
        int elemento = cola[front];
        front = (front + 1) % cola.length;
        size--;
        System.out.println("Desencolado: " + elemento);
        return elemento;
    }

    // Peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Cola vacía.");
            return -1;
        }
        return cola[front];
    }

    // Vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Mostrar cola
    public void mostrarCola() {
        if (isEmpty()) {
            System.out.println("Cola vacía.");
            return;
        }
        System.out.print("Elementos en la cola: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % cola.length;
            System.out.print(cola[index] + " ");
        }
        System.out.println();
    }

    // Main para probar
    public static void main(String[] args) {
        ColaCircularArray cola = new ColaCircularArray(5);

        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        cola.mostrarCola();

        System.out.println("Frente: " + cola.peek());
        cola.desencolar();
        cola.mostrarCola();

        cola.encolar(40);
        cola.encolar(50);
        cola.encolar(60); // intento de cola llena
        cola.mostrarCola();
    }
}
