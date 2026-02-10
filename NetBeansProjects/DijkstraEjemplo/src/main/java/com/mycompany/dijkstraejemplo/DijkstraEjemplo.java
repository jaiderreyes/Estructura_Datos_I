/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dijkstraejemplo;

/**
 *
 * @author jaiderreyes
 */




import java.util.*;

class Grafo {
    private Map<String, List<Arista>> nodos = new HashMap<>();

    // Añadir nodo con sus conexiones
    public void addNodo(String nodo) {
        nodos.put(nodo, new ArrayList<>());
    }

    // Añadir arista entre dos nodos con un peso
    public void addArista(String origen, String destino, int peso) {
        nodos.get(origen).add(new Arista(destino, peso));
        nodos.get(destino).add(new Arista(origen, peso)); // Si el grafo es no dirigido
    }

    // Algoritmo de Dijkstra
    public Map<String, Integer> dijkstra(String nodoInicial) {
        Map<String, Integer> distancias = new HashMap<>();
        Set<String> nodosVisitados = new HashSet<>();
        PriorityQueue<Arista> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.peso));

        // Inicializar las distancias
        for (String nodo : nodos.keySet()) {
            distancias.put(nodo, Integer.MAX_VALUE); // Todas las distancias son infinitas al principio
        }
        distancias.put(nodoInicial, 0); // Distancia del nodo inicial a sí mismo es 0
        pq.add(new Arista(nodoInicial, 0));

        while (!pq.isEmpty()) {
            Arista actual = pq.poll();
            String nodoActual = actual.destino;

            if (nodosVisitados.contains(nodoActual)) {
                continue;
            }

            nodosVisitados.add(nodoActual);

            // Actualizar las distancias a los vecinos
            for (Arista vecino : nodos.get(nodoActual)) {
                if (!nodosVisitados.contains(vecino.destino)) {
                    int nuevaDistancia = distancias.get(nodoActual) + vecino.peso;
                    if (nuevaDistancia < distancias.get(vecino.destino)) {
                        distancias.put(vecino.destino, nuevaDistancia);
                        pq.add(new Arista(vecino.destino, nuevaDistancia));
                    }
                }
            }
        }

        return distancias;
    }
}

class Arista {
    String destino;
    int peso;

    public Arista(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

public class DijkstraEjemplo {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Añadir nodos (amigos)
        grafo.addNodo("Ana");
        grafo.addNodo("Bruno");
        grafo.addNodo("Carlos");
        grafo.addNodo("Diana");
        grafo.addNodo("Eva");

        // Añadir conexiones (amistades con peso 1)
        grafo.addArista("Ana", "Bruno", 1);
        grafo.addArista("Ana", "Carlos", 1);
        grafo.addArista("Ana", "Diana", 1);
        grafo.addArista("Bruno", "Carlos", 1);
        grafo.addArista("Carlos", "Diana", 1);
        grafo.addArista("Carlos", "Eva", 1);

        // Ejecutar Dijkstra desde "Ana"
        Map<String, Integer> distancias = grafo.dijkstra("Ana");

        // Mostrar las distancias desde "Ana" a todos los demás nodos
        for (Map.Entry<String, Integer> entry : distancias.entrySet()) {
            System.out.println("Distancia de Ana a " + entry.getKey() + " es " + entry.getValue());
        }




}
