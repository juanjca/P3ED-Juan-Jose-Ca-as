import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.List;

public class EjemploPracticoDijkstra {

    public static void main(String[] args) {

        // Crear un grafo dirigido ponderado para representar las calles de la ciudad
        Graph<String, DefaultWeightedEdge> ciudad = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        // Agregar intersecciones como vértices al grafo
        ciudad.addVertex("AlmacenCentral");
        ciudad.addVertex("HospitalA");
        ciudad.addVertex("HospitalB");
        ciudad.addVertex("HospitalC");

        // Agregar calles como aristas ponderadas al grafo
        DefaultWeightedEdge edge1 = ciudad.addEdge("AlmacenCentral", "HospitalA");
        ciudad.setEdgeWeight(edge1, 10); // Tiempo de viaje de 10 minutos
        DefaultWeightedEdge edge2 = ciudad.addEdge("AlmacenCentral", "HospitalB");
        ciudad.setEdgeWeight(edge2, 15); // Tiempo de viaje de 15 minutos
        DefaultWeightedEdge edge3 = ciudad.addEdge("AlmacenCentral", "HospitalC");
        ciudad.setEdgeWeight(edge3, 20); // Tiempo de viaje de 20 minutos

        // Ejecutar el algoritmo de Dijkstra para encontrar la ruta más corta desde el almacén central a cada hospital
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(ciudad);

        // Encontrar la ruta más corta desde el almacén central a cada hospital
        List<String> rutaHospitalA = dijkstra.getPath("AlmacenCentral", "HospitalA").getVertexList();
        List<String> rutaHospitalB = dijkstra.getPath("AlmacenCentral", "HospitalB").getVertexList();
        List<String> rutaHospitalC = dijkstra.getPath("AlmacenCentral", "HospitalC").getVertexList();

        // Mostrar las rutas más cortas
        System.out.println("Ruta más corta al Hospital A: " + rutaHospitalA);
        System.out.println("Ruta más corta al Hospital B: " + rutaHospitalB);
        System.out.println("Ruta más corta al Hospital C: " + rutaHospitalC);
    }
}
