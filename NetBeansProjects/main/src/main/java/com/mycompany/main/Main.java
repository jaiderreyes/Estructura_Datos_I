/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author jaiderreyes
 */
public class Main {
// Definición de la clase Nodo
class Nodo {
    int dato;
    Nodo izquierdo, derecho;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = this.derecho = null;
    }
}

// Definición de la clase Árbol Binario
class ArbolBinario {
    Nodo raiz;

    // Constructor
    public ArbolBinario() {
        raiz = null;
    }

    // Recorrido en orden (In-Order: Izquierda -> Nodo -> Derecha)
    public void inOrden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        inOrden(nodo.izquierdo);
        System.out.print(nodo.dato + " - ");
        inOrden(nodo.derecho);
    }

    // Recorrido en preorden (Pre-Order: Nodo -> Izquierda -> Derecha)
    public void preOrden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        System.out.print(nodo.dato + " - ");
        preOrden(nodo.izquierdo);
        preOrden(nodo.derecho);
    }

    // Recorrido en postorden (Post-Order: Izquierda -> Derecha -> Nodo)
    public void postOrden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        postOrden(nodo.izquierdo);
        postOrden(nodo.derecho);
        System.out.print(nodo.dato + " - ");
    }

    // Métodos para iniciar los recorridos desde la raíz
    public void recorrerInOrden() {
        inOrden(raiz);
        System.out.println();
    }

    public void recorrerPreOrden() {
        preOrden(raiz);
        System.out.println();
    }

    public void recorrerPostOrden() {
        postOrden(raiz);
        System.out.println();
    }
}

// Clase principal para probar el código
public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        // Creación manual del árbol
        arbol.raiz = new Nodo(5);
        arbol.raiz.izquierdo = new Nodo(3);
        arbol.raiz.derecho = new Nodo(8);
        arbol.raiz.izquierdo.izquierdo = new Nodo(1);
        arbol.raiz.izquierdo.derecho = new Nodo(4);
        arbol.raiz.derecho.derecho = new Nodo(10);

        // Ejecutar los recorridos
        System.out.println("Recorrido In-Order:");
        arbol.recorrerInOrden();

        System.out.println("Recorrido Pre-Order:");
        arbol.recorrerPreOrden();

        System.out.println("Recorrido Post-Order:");
        arbol.recorrerPostOrden();
    }
}
