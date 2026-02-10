/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mst;

/**
 *
 * @author jaiderreyes
 */

//package com.mycompany.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Mst {
    
    private int vertices; // Número de vértices en el grafo
    
    // Clase para representar una arista de un grafo
    class Edge {
        int src, dest, weight;
        
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    // Clase para representar un subconjunto para la unión y la búsqueda
    class Subset {
        int parent, rank;
        
        Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }
    
    // Lista de aristas del grafo
    private List<Edge> edges = new ArrayList<>();
    
    // Constructor
    public Mst(int vertices) {
        this.vertices = vertices;
    }
    
    // Método para añadir arista
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    // Algoritmo de Kruskal para encontrar el Mst
    public void kruskalMst() {
        // Lista para almacenar el Mst resultante
        List<Edge> result = new ArrayList<>();
        
        // Ordena las aristas por peso
        Collections.sort(edges, Comparator.comparingInt(edge -> edge.weight));
        
        // Crea `V` subconjuntos con un solo elemento cada uno
        Subset[] subsets = new Subset[vertices];
        for (int v = 0; v < vertices; v++) {
            subsets[v] = new Subset(v, 0);
        }
        
        for (Edge edge : edges) {
            int root1 = find(subsets, edge.src);
            int root2 = find(subsets, edge.dest);
            
            // Si incluir esta arista no causa un ciclo, inclúyela en el resultado
            if (root1 != root2) {
                result.add(edge);
                union(subsets, root1, root2);
            }
        }
        
        // Imprimir el Mst
        System.out.println("Aristas en el Mst usando Kruskal:");
        for (Edge edge : result) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
    }

    // Encuentra la raíz de un subconjunto
    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // Realiza la unión de dos subconjuntos
    private void union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);
        
        if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else if (subsets[rootX].rank > subsets[rootY].rank) {
            subsets[rootY].parent = rootX;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    // Algoritmo de Prim para encontrar el Mst
    public void primMst() {
        boolean[] inMst = new boolean[vertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        
        // Iniciar desde el vértice 0
        inMst[0] = true;
        for (Edge edge : edges) {
            if (edge.src == 0 || edge.dest == 0) {
                pq.add(edge);
            }
        }
        
        List<Edge> mstEdges = new ArrayList<>();
        
        while (!pq.isEmpty() && mstEdges.size() < vertices - 1) {
            Edge edge = pq.poll();
            
            if (!inMst[edge.dest]) {
                inMst[edge.dest] = true;
                mstEdges.add(edge);
                
                for (Edge nextEdge : edges) {
                    if (nextEdge.src == edge.dest && !inMst[nextEdge.dest]) {
                        pq.add(nextEdge);
                    } else if (nextEdge.dest == edge.dest && !inMst[nextEdge.src]) {
                        pq.add(nextEdge);
                    }
                }
            }
        }
        
        // Imprimir el Mst
        System.out.println("Aristas en el Mst usando Prim:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
    }
    
    public static void main(String[] args) {
        Mst mst = new Mst(4); // Ejemplo de un grafo con 4 vértices
        mst.addEdge(0, 1, 10);
        mst.addEdge(0, 2, 6);
        mst.addEdge(0, 3, 5);
        mst.addEdge(1, 3, 15);
        mst.addEdge(2, 3, 4);
        
        System.out.println("Ejecutando Kruskal:");
        mst.kruskalMst();
        
        System.out.println("\nEjecutando Prim:");
        mst.primMst();
    }
}