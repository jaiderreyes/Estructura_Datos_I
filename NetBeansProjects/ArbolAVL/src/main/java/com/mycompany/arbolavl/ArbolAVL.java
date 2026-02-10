/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author:  Ing Jaider Reyes Herazo
 * Asignatura: Estructura De Datos II
 * Explicacion detallada de arbol AVL
 */
package com.mycompany.arbolavl;

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

    //Rotación simple a la izquierda
   /*NodoAVL rotacionIzquierda(NodoAVL y) {
        NodoAVL x = y.derecho;
        NodoAVL T2 = x.izquierdo;

        // Realizar la rotación
        x.izquierdo = y;
        y.derecho = T2;

        // Actualizar alturas
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        // Retornar la nueva raíz
        return x;
    }*/
    
    
    // Método para realizar una rotación a la izquierda (balancea el árbol)
    NodoAVL rotacionIzquierda(NodoAVL nodoDesequilibrado) {
        NodoAVL nuevoPadre = nodoDesequilibrado.derecho;
        NodoAVL subArbolIzquierdo = nuevoPadre.izquierdo;

        // Realiza la rotación
        nuevoPadre.izquierdo = nodoDesequilibrado;
        nodoDesequilibrado.derecho = subArbolIzquierdo;

        // Actualiza las alturas
        nodoDesequilibrado.altura = Math.max(altura(nodoDesequilibrado.izquierdo), altura(nodoDesequilibrado.derecho)) + 1;
        nuevoPadre.altura = Math.max(altura(nuevoPadre.izquierdo), altura(nuevoPadre.derecho)) + 1;

        // Retorna el nuevo padre
        return nuevoPadre;
    }


    // Insertar un nodo en el árbol AVL
    NodoAVL insertar(NodoAVL nodo, int valor) {
        // Paso 1: Realizar la inserción normal en el árbol binario de búsqueda
        if (nodo == null)
            return (new NodoAVL(valor));

        if (valor < nodo.valor)
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        else if (valor > nodo.valor)
            nodo.derecho = insertar(nodo.derecho, valor);
        else  // No se permiten valores duplicados
            return nodo;

        // Paso 2: Actualizar la altura del ancestro nodo
        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));

        // Paso 3: Obtener el factor de balance de este ancestro para ver si se desequilibra
        int balance = obtenerBalance(nodo);

        // Si el nodo está desequilibrado, hay 4 casos

        // Caso LL: Rotación simple a la izquierda
        if (balance < -1 && valor > nodo.derecho.valor)
            return rotacionIzquierda(nodo);

        // Otros casos de rotaciones pueden ser agregados aquí (RR, LR, RL)
        
        return nodo;
    }

    // Obtener el factor de balance del nodo
    int obtenerBalance(NodoAVL N) {
        if (N == null)
            return 0;
        return altura(N.izquierdo) - altura(N.derecho);
    }

    // Método para imprimir el árbol en preorden
    void preOrder(NodoAVL nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preOrder(nodo.izquierdo);
            preOrder(nodo.derecho);
        }
    }
    
    
    // Método para imprimir el árbol de manera jerárquica
    public void imprimirArbol(NodoAVL nodo, String prefijo, boolean esDerecho) {
        if (nodo != null) {
            imprimirArbol(nodo.derecho, prefijo + (esDerecho ? "        " : " |      "), true);
            System.out.println(prefijo + (esDerecho ? " /-- " : " \\-- ") + nodo.valor);
            imprimirArbol(nodo.izquierdo, prefijo + (esDerecho ? " |      " : "        "), false);
        }
    }
}

public class ArbolAVL {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        arbol.raiz = arbol.insertar(arbol.raiz, 10);
        arbol.raiz = arbol.insertar(arbol.raiz, 20);
        arbol.raiz = arbol.insertar(arbol.raiz, 30);  // Esto causará la rotación LL
        
        //nuevo
       
        
        // Imprimir el árbol AVL
        System.out.println("Estructura del árbol AVL:");
        arbol.imprimirArbol(arbol.raiz, "", true);
        
        //     arbol.raiz = arbol.insertar(arbol.raiz, 40);
   //arbol.raiz = arbol.insertar(arbol.raiz, 15);
        // Mostrar el árbol en preorden
        System.out.println("Árbol AVL en preorden tras las inserciones:");
        arbol.preOrder(arbol.raiz);
    }
}
