package listacirculardoble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaCircularDoble lista = new ListaCircularDoble();
        Scanner sc = new Scanner(System.in);
        int opcion, valor;

        do {
            System.out.println("\n=== MENÚ - LISTA CIRCULAR DOBLE ===");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Mostrar adelante (→)");
            System.out.println("3. Mostrar atrás (←)");
            System.out.println("4. Buscar nodo");
            System.out.println("5. Eliminar nodo");
            System.out.println("6. Contar nodos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            while (!sc.hasNextInt()) { sc.next(); System.out.print("Ingrese un número: "); }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el valor del nodo: ");
                    while (!sc.hasNextInt()) { sc.next(); System.out.print("Ingrese un número: "); }
                    valor = sc.nextInt();
                    lista.insertar(valor);
                }
                case 2 -> lista.mostrarAdelante();
                case 3 -> lista.mostrarAtras();
                case 4 -> {
                    System.out.print("Ingrese el valor a buscar: ");
                    while (!sc.hasNextInt()) { sc.next(); System.out.print("Ingrese un número: "); }
                    valor = sc.nextInt();
                    System.out.println(lista.buscar(valor) ? "Nodo encontrado" : " Nodo no encontrado");
                }
                case 5 -> {
                    System.out.print("Ingrese el valor a eliminar: ");
                    while (!sc.hasNextInt()) { sc.next(); System.out.print("Ingrese un número: "); }
                    valor = sc.nextInt();
                    lista.eliminar(valor);
                }
                case 6 -> System.out.println(" Total de nodos en la lista: " + lista.contarNodos());
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println(" Opción no válida.");
            }
        } while (opcion != 7);

        sc.close();
    }
}
