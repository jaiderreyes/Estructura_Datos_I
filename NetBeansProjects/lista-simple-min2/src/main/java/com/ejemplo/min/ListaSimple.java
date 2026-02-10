package com.ejemplo.min;

public class ListaSimple {
    private Nodo cabeza;

    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
    }

    public void mostrar() {
        Nodo actual = cabeza;
        if (actual == null) {
            System.out.println("Lista vacía");
            return;
        }
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}
