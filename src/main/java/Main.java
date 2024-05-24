import org.kruskal.Arista;
import org.kruskal.Kruskal;
import org.kruskal.Utils;
import org.kruskal.Vertice;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Probar ciclo en grafo no dirigido
        System.out.println("Probando ciclo en grafo no dirigido:");
        probar_ciclo_grafo_no_dirigido();

        // Probar el algoritmo de Kruskal para encontrar el árbol de cobertura mínima
        System.out.println("\nProbando el algoritmo de Kruskal para encontrar el árbol de cobertura mínima:");
        probarKruskalMinimo();

        // Probar el algoritmo de Kruskal para encontrar el árbol de cobertura máxima
        System.out.println("\nProbando el algoritmo de Kruskal para encontrar el árbol de cobertura máxima:");
        probarKruskalMaximo();

        // Probar ciclo en grafo dirigido
        System.out.println("\nProbando ciclo en grafo dirigido:");
        probarCicloEnGrafoDirigido();
    }

    public static void probar_ciclo_grafo_no_dirigido() {
        // Creación de los vértices
        Vertice<String> laureles = new Vertice<>("Laureles");
        Vertice<String> sanJulian = new Vertice<>("San Julian");
        Vertice<String> coinca = new Vertice<>("Coinca");
        Vertice<String> portal = new Vertice<>("Portal del Quindio");
        Vertice<String> netania = new Vertice<>("Netania");
        Vertice<String> niteroi = new Vertice<>("Niteroi");

        // Adición de vecinos (aristas) entre los vértices
        laureles.agregarVecino(sanJulian);
        sanJulian.agregarVecino(laureles);

        laureles.agregarVecino(coinca);
        coinca.agregarVecino(laureles);

        sanJulian.agregarVecino(netania);
        netania.agregarVecino(sanJulian);

        coinca.agregarVecino(portal);
        portal.agregarVecino(coinca);

        portal.agregarVecino(netania);
        netania.agregarVecino(portal);

        netania.agregarVecino(niteroi);
        niteroi.agregarVecino(netania);

        // Creación del grafo como una lista de vértices
        List<Vertice<String>> grafo = Arrays.asList(
                laureles, sanJulian, coinca, portal, netania, niteroi
        );

        // Verificación de la existencia de ciclos en el grafo
        System.out.println(new Utils<String>().tieneCicloGrafoNoDirigido(grafo));
    }

    public static void probarKruskalMinimo() {
        // Creación de los vértices
        Vertice<String> laureles = new Vertice<>("Laureles");
        Vertice<String> sanJulian = new Vertice<>("San Julian");
        Vertice<String> coinca = new Vertice<>("Coinca");
        Vertice<String> portal = new Vertice<>("Portal del Quindio");
        Vertice<String> netania = new Vertice<>("Netania");

        // Creación del grafo como una lista de aristas
        List<Arista<String>> grafo = Arrays.asList(
                new Arista<String>(laureles, sanJulian, 5),
                new Arista<String>(laureles, coinca, 2),
                new Arista<String>(sanJulian, coinca, 3),
                new Arista<String>(sanJulian, portal, 8),
                new Arista<String>(sanJulian, netania, 7),
                new Arista<String>(portal, netania, 6),
                new Arista<String>(coinca, netania, 3)
        );

        // Procesamiento del grafo utilizando el algoritmo de Kruskal para encontrar el árbol de cobertura mínima
        new Kruskal<String>(grafo, false).procesarMinimo();
    }

    public static void probarKruskalMaximo() {
        // Creación de los vértices
        Vertice<String> laureles = new Vertice<>("Laureles");
        Vertice<String> sanJulian = new Vertice<>("San Julian");
        Vertice<String> coinca = new Vertice<>("Coinca");
        Vertice<String> portal = new Vertice<>("Portal del Quindio");
        Vertice<String> netania = new Vertice<>("Netania");

        // Creación del grafo como una lista de aristas
        List<Arista<String>> grafo = Arrays.asList(
                new Arista<String>(laureles, sanJulian, 5),
                new Arista<String>(laureles, coinca, 2),
                new Arista<String>(sanJulian, coinca, 3),
                new Arista<String>(sanJulian, portal, 8),
                new Arista<String>(sanJulian, netania, 7),
                new Arista<String>(portal, netania, 6),
                new Arista<String>(coinca, netania, 3)
        );

        // Procesamiento del grafo utilizando el algoritmo de Kruskal para encontrar el árbol de cobertura máxima
        new Kruskal<String>(grafo, true).procesarMaximo();
    }

    public static void probarCicloEnGrafoDirigido() {
        // Creación de los vértices
        Vertice<String> laureles = new Vertice<>("Laureles");
        Vertice<String> sanJulian = new Vertice<>("San Julian");
        Vertice<String> coinca = new Vertice<>("Coinca");
        Vertice<String> portal = new Vertice<>("Portal del Quindio");
        Vertice<String> netania = new Vertice<>("Netania");
        Vertice<String> niteroi = new Vertice<>("Niteroi");

        // Adición de vecinos (aristas) entre los vértices
        laureles.agregarVecino(sanJulian);
        laureles.agregarVecino(coinca);

        sanJulian.agregarVecino(coinca);
        sanJulian.agregarVecino(portal);
        sanJulian.agregarVecino(netania);

        coinca.agregarVecino(portal);

        portal.agregarVecino(netania);

        netania.agregarVecino(niteroi);

        niteroi.agregarVecino(portal);

        // Creación del grafo como una lista de vértices
        List<Vertice<String>> grafo = Arrays.asList(
                laureles, sanJulian, coinca, portal, netania, niteroi
        );

        // Verificación de la existencia de ciclos en el grafo dirigido
        System.out.println(new Utils<String>().tieneCicloGrafoDirigido(grafo));
    }
}