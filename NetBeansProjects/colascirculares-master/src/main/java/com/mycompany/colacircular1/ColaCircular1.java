package com.mycompany.colacircular1;

import java.util.Scanner;

public class ColaCircular1 {
    private int[] cola;
    private int front;
    private int rear;
    private int count;
    private int tamaño;

    // Constructor: define el tamaño de la cola
    public ColaCircular1(int tamaño) {
        this.tamaño = tamaño;
        cola = new int[tamaño];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Encolar (agregar elemento)
    public void encolar(int elemento) {
        if (estaLlena()) {
            System.out.println("⚠️ Cola llena. No se puede encolar.");
            return;
        }
        rear = (rear + 1) % tamaño;
        cola[rear] = elemento;
        count++;
        System.out.println("✅ Encolado: " + elemento);
    }

    // Desencolar (eliminar elemento)
    public void desencolar() {
        if (estaVacia()) {
            System.out.println("⚠️ Cola vacía. No se puede desencolar.");
            return;
        }
        int elemento = cola[front];
        front = (front + 1) % tamaño;
        count--;
        System.out.println("🚪 Desencolado: " + elemento);
    }

    // Ver el elemento al frente
    public void verFrente() {
        if (estaVacia()) {
            System.out.println("⚠️ Cola vacía.");
        } else {
            System.out.println("👁️ Elemento al frente: " + cola[front]);
        }
    }

    // Mostrar todos los elementos de la cola
    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("⚠️ Cola vacía.");
            return;
        }
        System.out.print("📦 Elementos en la cola: ");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % tamaño;
            System.out.print(cola[index] + " ");
        }
        System.out.println();
    }

    // Verificar si la cola está vacía
    public boolean estaVacia() {
        return count == 0;
    }

    // Verificar si la cola está llena
    public boolean estaLlena() {
        return count == tamaño;
    }

    // Método principal (main)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ColaCircular1 cola = new ColaCircular1(5);

        int opcion;
        do {
            System.out.println("\n--- MENÚ COLA CIRCULAR ---");
            System.out.println("1. Encolar elemento");
            System.out.println("2. Desencolar elemento");
            System.out.println("3. Ver frente");
            System.out.println("4. Mostrar cola");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número a encolar: ");
                    int valor = sc.nextInt();
                    cola.encolar(valor);
                    break;
                case 2:
                    cola.desencolar();
                    break;
                case 3:
                    cola.verFrente();
                    break;
                case 4:
                    cola.mostrarCola();
                    break;
                case 5:
                    System.out.println("👋 Saliendo...");
                    break;
                default:
                    System.out.println("❌ Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
