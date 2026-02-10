/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arbolbinario;
//package arbolbinario;

import java.util.Scanner;
/**
 *
 * @author jaiderreyes
 */

class Nodo {
    int dato;
    Nodo izquierdo, derecho;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = this.derecho = null;
    }
}

/*
Cada nodo del árbol almacena un número (dato).
Tiene dos enlaces (izquierdo y derecho) para conectar con otros nodos.
Cuando se crea un nodo, sus enlaces son null (vacíos).

*/


public class ArbolBinario {

/*
    La clase ArbolBinario tiene una variable raiz que representa el primer nodo del árbol.
  
    */    
    
    Nodo raiz;


    // Constructor    (public ArbolBinario()) inicializa el árbol vacío (raiz = null).

    public ArbolBinario() { //
        raiz = null;
    }

    // Insertar un nodo en el árbol (de forma manual para pruebas)
    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }
    /*
    insertar(int dato): Llama al método recursivo insertarRec().
insertarRec()
    */
    private Nodo insertarRec(Nodo nodo, int dato) {
        if (nodo == null) { //Si el nodo es null, crea un nuevo nodo.
            return new Nodo(dato);
        }
        if (dato < nodo.dato) { //Si el valor es menor, lo inserta a la izquierda.
            nodo.izquierdo = insertarRec(nodo.izquierdo, dato);
        } else if (dato > nodo.dato) { // Si el valor es mayor, lo inserta a la derecha
            nodo.derecho = insertarRec(nodo.derecho, dato);
        }
        return nodo;
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
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();

        System.out.println("Ingrese la cantidad de nodos del árbol:");
        int cantidad = scanner.nextInt();

        System.out.println("Ingrese los valores del árbol:");
        for (int i = 0; i < cantidad; i++) {
            int valor = scanner.nextInt();
            arbol.insertar(valor);
        }

        // Ejecutar los recorridos
        System.out.println("\nRecorrido In-Order:");
        arbol.recorrerInOrden();

        System.out.println("Recorrido Pre-Order:");
        arbol.recorrerPreOrden();

        System.out.println("Recorrido Post-Order:");
        arbol.recorrerPostOrden();
    }
}
