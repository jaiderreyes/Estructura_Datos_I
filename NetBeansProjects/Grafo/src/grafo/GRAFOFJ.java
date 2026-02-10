package grafo;

import java.util.*;

// Clase que representa un grafo
class Grafo {
    // Mapa que asocia cada nodo con una lista de sus aristas (conexiones)
    private Map<String, List<Arista>> nodos = new HashMap<>();

    // Método para agregar un nodo al grafo
    public void addNodo(String nodo) {
        nodos.put(nodo, new ArrayList<>()); // Inicializa una lista vacía de aristas para el nodo
    }

    // Método para agregar una arista (conexión) entre dos nodos con un peso específico
    public void addArista(String origen, String destino, int peso) {
        // Añade la arista del nodo origen al nodo destino con el peso dado
        nodos.get(origen).add(new Arista(destino, peso));
        // Añade también la arista inversa, ya que el grafo es no dirigido
        nodos.get(destino).add(new Arista(origen, peso));
    }

    // Algoritmo de Dijkstra para encontrar las distancias más cortas desde un nodo inicial
    public Map<String, Integer> dijkstra(String nodoInicial) {
        // Mapa que almacena la distancia mínima desde el nodo inicial a cada nodo
        Map<String, Integer> distancias = new HashMap<>();
        // Conjunto que rastrea los nodos que ya han sido visitados
        Set<String> nodosVisitados = new HashSet<>();
        // Cola de prioridad para seleccionar el nodo con la distancia más corta
        PriorityQueue<Arista> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.peso));

        // Inicializar todas las distancias como infinitas (representadas por Integer.MAX_VALUE)
        for (String nodo : nodos.keySet()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
        // La distancia del nodo inicial a sí mismo es 0
        distancias.put(nodoInicial, 0);
        // Agregar el nodo inicial a la cola con una distancia de 0
        pq.add(new Arista(nodoInicial, 0));

        // Mientras haya nodos en la cola de prioridad
        while (!pq.isEmpty()) {
            // Tomar el nodo con la distancia más corta
            Arista actual = pq.poll();
            String nodoActual = actual.destino;

            // Si el nodo ya fue visitado, saltar a la siguiente iteración
            if (nodosVisitados.contains(nodoActual)) {
                continue;
            }

            // Marcar el nodo como visitado
            nodosVisitados.add(nodoActual);

            // Examinar todas las aristas (vecinos) del nodo actual
            for (Arista vecino : nodos.get(nodoActual)) {
                // Si el vecino no ha sido visitado
                if (!nodosVisitados.contains(vecino.destino)) {
                    // Calcular la nueva distancia al vecino a través del nodo actual
                    int nuevaDistancia = distancias.get(nodoActual) + vecino.peso;
                    // Si la nueva distancia es menor que la distancia almacenada previamente
                    if (nuevaDistancia < distancias.get(vecino.destino)) {
                        // Actualizar la distancia con la nueva distancia más corta
                        distancias.put(vecino.destino, nuevaDistancia);
                        // Añadir el vecino a la cola con la nueva distancia
                        pq.add(new Arista(vecino.destino, nuevaDistancia));
                    }
                }
            }
        }

        // Retornar el mapa de distancias desde el nodo inicial
        return distancias;
    }
}

// Clase que representa una arista (conexión) entre nodos
class Arista {
    String destino; // El nodo de destino de la arista
    int peso; // El peso de la arista (distancia)

    // Constructor para inicializar la arista con el nodo de destino y el peso
    public Arista(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

// Clase principal para ejecutar el programa
public class GRAFOFJ {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Agregar nodos que representan los centros clínicos
        grafo.addNodo("Salida");
        grafo.addNodo("Manantiales");
        grafo.addNodo("Santa María");
        grafo.addNodo("Las Peñitas");
        grafo.addNodo("María Reina");
        grafo.addNodo("Sincelejo");
        grafo.addNodo("Salud Social");
        grafo.addNodo("Santa Isabela");
        grafo.addNodo("UT Centro");

        // Agregar aristas que representan las distancias entre los centros clínicos
        // Solo se agregan las aristas con distancias finitas (omitimos "∞")
        grafo.addArista("Salida", "Manantiales", 10); // Distancia de 10
        grafo.addArista("Salida", "María Reina", 20); // Distancia de 20
        grafo.addArista("Salida", "Salud Social", 30); // Distancia de 30
        grafo.addArista("Salida", "Santa Isabela", 40); // Distancia de 40

        grafo.addArista("Manantiales", "Santa María", 15); // Distancia de 15
        grafo.addArista("Manantiales", "Sincelejo", 25); // Distancia de 25
        grafo.addArista("Manantiales", "Santa Isabela", 40); // Distancia de 40

        grafo.addArista("Santa María", "Las Peñitas", 5); // Distancia de 5
        grafo.addArista("Santa María", "Sincelejo", 10); // Distancia de 10
        grafo.addArista("Santa María", "UT Centro", 25); // Distancia de 25

        grafo.addArista("Las Peñitas", "Sincelejo", 20); // Distancia de 20
        grafo.addArista("Las Peñitas", "Salud Social", 35); // Distancia de 35

        grafo.addArista("María Reina", "Sincelejo", 10); // Distancia de 10
        grafo.addArista("María Reina", "Salud Social", 30); // Distancia de 30

        grafo.addArista("Sincelejo", "Salud Social", 15); // Distancia de 15
        grafo.addArista("Sincelejo", "Santa Isabela", 5); // Distancia de 5
        grafo.addArista("Sincelejo", "UT Centro", 20); // Distancia de 20

        grafo.addArista("Salud Social", "UT Centro", 10); // Distancia de 10

        // Ejecutar el algoritmo de Dijkstra desde el nodo "Salida"
        Map<String, Integer> distancias = grafo.dijkstra("Salida");

        // Mostrar las distancias desde "Salida" a todos los demás nodos
        for (Map.Entry<String, Integer> entry : distancias.entrySet()) {
            System.out.println("Distancia desde Salida a " + entry.getKey() + " es " + entry.getValue());
        }
    }
}