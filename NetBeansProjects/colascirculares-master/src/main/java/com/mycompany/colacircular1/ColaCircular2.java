package com.mycompany.colacircular1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ColaCircular2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> cola = new ArrayDeque<>();
        int opcion;

        do {
            System.out.println("\n--- MENÚ COLA CIRCULAR (ArrayDeque) ---");
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
                    cola.add(valor);
                    System.out.println("✅ Encolado: " + valor);
                    break;

                case 2:
                    if (cola.isEmpty()) {
                        System.out.println("⚠️ Cola vacía. No se puede desencolar.");
                    } else {
                        int eliminado = cola.remove();
                        System.out.println("🚪 Desencolado: " + eliminado);
                    }
                    break;

                case 3:
                    if (cola.isEmpty()) {
                        System.out.println("⚠️ Cola vacía.");
                    } else {
                        System.out.println("👁️ Elemento al frente: " + cola.peek());
                    }
                    break;

                case 4:
                    if (cola.isEmpty()) {
                        System.out.println("⚠️ Cola vacía.");
                    } else {
                        System.out.println("📦 Elementos en la cola: " + cola);
                    }
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
