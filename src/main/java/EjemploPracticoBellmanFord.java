import java.util.*;

public class EjemploPracticoBellmanFord {

    // Clase Edge
    static class Edge {
        int source; // Vértice de origen
        int destination; // Vértice de destino
        int weight; // Peso de la arista

        // Constructor de la clase Edge
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Clase Graph
    static class Graph {
        int vertices; // Número de vértices en el grafo
        int edges; // Número de aristas en el grafo
        List<Edge> edgeList; // Lista de aristas del grafo

        // Constructor de la clase Graph
        public Graph(int vertices, int edges) {
            this.vertices = vertices;
            this.edges = edges;
            edgeList = new ArrayList<>();
        }

        // Método para agregar una arista al grafo
        public void addEdge(int source, int destination, int weight) {
            edgeList.add(new Edge(source, destination, weight));
        }

        // Implementación del algoritmo de Bellman-Ford
        public void bellmanFord(int source) {
            int[] distance = new int[vertices]; // Array de distancias desde el vértice fuente
            Arrays.fill(distance, Integer.MAX_VALUE); // Inicializar distancias con valor máximo
            distance[source] = 0; // Distancia desde la fuente a sí misma es 0

            // Relajar todas las aristas V-1 veces
            for (int i = 0; i < vertices - 1; i++) {
                for (Edge edge : edgeList) {
                    if (distance[edge.source] != Integer.MAX_VALUE &&
                            distance[edge.source] + edge.weight < distance[edge.destination]) {
                        distance[edge.destination] = distance[edge.source] + edge.weight;
                    }
                }
            }

            // Comprobar la existencia de ciclos de peso negativo
            for (Edge edge : edgeList) {
                if (distance[edge.source] != Integer.MAX_VALUE &&
                        distance[edge.source] + edge.weight < distance[edge.destination]) {
                    System.out.println("Graph contains negative-weight cycle");
                    return;
                }
            }

            // Imprimir las distancias más cortas desde el vértice fuente
            System.out.println("Shortest distances from source:");
            for (int i = 0; i < vertices; i++) {
                System.out.println("Vertex " + i + ": " + distance[i]);
            }
        }
    }

    // Método principal para ejecutar el ejemplo práctico del algoritmo de Bellman-Ford
    public static void main(String[] args) {
        int vertices = 5;   // Número de vértices en el grafo
        int edges = 8;      // Número de aristas en el grafo
        Graph graph = new Graph(vertices, edges);

        // Agregar aristas al grafo
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, -2);
        graph.addEdge(1, 3, -4);
        graph.addEdge(1, 4, 6);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 2);

        // Ejecutar el algoritmo de Bellman-Ford desde el vértice fuente 0
        graph.bellmanFord(0);
    }
}