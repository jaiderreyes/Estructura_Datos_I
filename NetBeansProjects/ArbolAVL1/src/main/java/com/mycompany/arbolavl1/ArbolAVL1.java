/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arbolavl1;



// Clase para representar un nodo del árbol AVL
class NodoAVL {
    int valor;
    NodoAVL izquierdo, derecho;
    int altura;

    public NodoAVL(int valor) {
        this.valor = valor;
        this.altura = 1;  // Altura inicial
    }
}

// Clase que representa el árbol AVL y sus operaciones
class Arbol {
    NodoAVL raiz;

    // Obtener la altura del nodo
    int altura(NodoAVL N) {
        if (N == null)
            return 0;
        return N.altura;
    }

    // Obtener el factor de balance del nodo
    int obtenerBalance(NodoAVL N) {
        if (N == null)
            return 0;
        return altura(N.izquierdo) - altura(N.derecho);
    }

    // ROTACIÓN SIMPLE A LA DERECHA (LL)
    NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;

        // Rotar
        x.derecho = y;
        y.izquierdo = T2;

        // Actualizar alturas
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        // Retornar nueva raíz
        return x;
    }

    // ROTACIÓN SIMPLE A LA IZQUIERDA (RR)
    NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;

        // Rotar
        y.izquierdo = x;
        x.derecho = T2;

        // Actualizar alturas
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

        // Retornar nueva raíz
        return y;
    }

    // ROTACIÓN DOBLE IZQUIERDA-DERECHA (LR)
    NodoAVL rotacionIzquierdaDerecha(NodoAVL nodo) {
        nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
        return rotacionDerecha(nodo);
    }

    // ROTACIÓN DOBLE DERECHA-IZQUIERDA (RL)
    NodoAVL rotacionDerechaIzquierda(NodoAVL nodo) {
        nodo.derecho = rotacionDerecha(nodo.derecho);
        return rotacionIzquierda(nodo);
    }

    // Insertar un nodo en el árbol AVL
    NodoAVL insertar(NodoAVL nodo, int valor) {
        // Paso 1: Inserción normal
        if (nodo == null)
            return new NodoAVL(valor);

        if (valor < nodo.valor)
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        else if (valor > nodo.valor)
            nodo.derecho = insertar(nodo.derecho, valor);
        else
            return nodo;  // No se permiten duplicados

        // Paso 2: Actualizar altura
        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));

        // Paso 3: Obtener el factor de balance
        int balance = obtenerBalance(nodo);

        // ======== CASOS DE DESEQUILIBRIO ========

        // Caso LL (rotación a la derecha)
        if (balance > 1 && valor < nodo.izquierdo.valor)
            return rotacionDerecha(nodo);

        // Caso RR (rotación a la izquierda)
        if (balance < -1 && valor > nodo.derecho.valor)
            return rotacionIzquierda(nodo);

        // Caso LR (rotación izquierda-derecha)
        if (balance > 1 && valor > nodo.izquierdo.valor)
            return rotacionIzquierdaDerecha(nodo);

        // Caso RL (rotación derecha-izquierda)
        if (balance < -1 && valor < nodo.derecho.valor)
            return rotacionDerechaIzquierda(nodo);

        // Si no se requiere rotación
        return nodo;
    }

    // Imprimir el árbol en preorden
    void preOrder(NodoAVL nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preOrder(nodo.izquierdo);
            preOrder(nodo.derecho);
        }
    }

    // Imprimir el árbol de manera jerárquica
    public void imprimirArbol(NodoAVL nodo, String prefijo, boolean esDerecho) {
        if (nodo != null) {
            imprimirArbol(nodo.derecho, prefijo + (esDerecho ? "        " : " |      "), true);
            System.out.println(prefijo + (esDerecho ? " /-- " : " \\-- ") + nodo.valor);
            imprimirArbol(nodo.izquierdo, prefijo + (esDerecho ? " |      " : "        "), false);
        }
    }
}
public class ArbolAVL1 {

    public static void main(String[] args) {
       Arbol arbol = new Arbol();

        // Inserciones que provocan diferentes rotaciones
        arbol.raiz = arbol.insertar(arbol.raiz, 10);
        arbol.raiz = arbol.insertar(arbol.raiz, 20);
        arbol.raiz = arbol.insertar(arbol.raiz, 30);  // RR
        arbol.raiz = arbol.insertar(arbol.raiz, 25);  // RL
        arbol.raiz = arbol.insertar(arbol.raiz, 5);   // LL
        arbol.raiz = arbol.insertar(arbol.raiz, 8);   // LR

        System.out.println("Estructura del árbol AVL:");
        arbol.imprimirArbol(arbol.raiz, "", true);

        System.out.println("\nÁrbol AVL en preorden:");
        arbol.preOrder(arbol.raiz);
    }
}
