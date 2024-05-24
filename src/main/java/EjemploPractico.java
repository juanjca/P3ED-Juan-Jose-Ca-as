import org.kruskal.Arista;
import org.kruskal.Kruskal;
import org.kruskal.Vertice;

import java.util.Arrays;
import java.util.List;

public class EjemploPractico {

    public static void main(String[] args) {
        // Crear vértices para representar comunidades locales en la región montañosa
        Vertice<String> comunidadA = new Vertice<>("Comunidad A");
        Vertice<String> comunidadB = new Vertice<>("Comunidad B");
        Vertice<String> comunidadC = new Vertice<>("Comunidad C");
        Vertice<String> comunidadD = new Vertice<>("Comunidad D");
        Vertice<String> comunidadE = new Vertice<>("Comunidad E");

        // Crear aristas ponderadas que representan los costos de tender tuberías entre comunidades
        List<Arista<String>> aristas = Arrays.asList(
                new Arista<String>(comunidadA, comunidadB, 10),
                new Arista<String>(comunidadA, comunidadC, 15),
                new Arista<String>(comunidadB, comunidadC, 20),
                new Arista<String>(comunidadB, comunidadD, 25),
                new Arista<String>(comunidadC, comunidadD, 30),
                new Arista<String>(comunidadC, comunidadE, 35),
                new Arista<String>(comunidadD, comunidadE, 40)
                // Agregar más aristas según sea necesario para representar otras conexiones
        );

        // Ejecutar el algoritmo de Kruskal para encontrar el árbol de cobertura mínima
        Kruskal<String> kruskal = new Kruskal<String>(aristas, false);
        kruskal.procesarMinimo();
    }
}
