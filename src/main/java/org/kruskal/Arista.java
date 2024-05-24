package org.kruskal;

// Clase genérica para representar una arista en un grafo
public class Arista<T> implements Comparable<Arista<T>> {

    // Atributos
    private final Vertice<T> origen; // Vértice de origen de la arista
    private final Vertice<T> destino; // Vértice de destino de la arista
    private final int peso; // Peso o costo de la arista

    // Constructor
    public Arista(Vertice<T> origen, Vertice<T> destino, int peso) {
        this.origen = origen; // Inicializa el vértice de origen
        this.destino = destino; // Inicializa el vértice de destino
        this.peso = peso; // Inicializa el peso de la arista
    }

    // Métodos

    public Vertice<T> getOrigen() {
        return origen; // Devuelve el vértice de origen
    }

    public Vertice<T> getDestino() {
        return destino; // Devuelve el vértice de destino
    }

    public int getPeso() {
        return peso; // Devuelve el peso de la arista
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Compara si los objetos son iguales
        if (!(obj instanceof Arista)) return false; // Verifica la instancia
        Arista<?> otra = (Arista<?>) obj; // Casteo seguro
        return peso == otra.peso && origen.equals(otra.origen) && destino.equals(otra.destino); // Compara los atributos
    }

    @Override
    public int hashCode() {
        int result = origen.hashCode(); // Genera el hash code del vértice de origen
        result = 31 * result + destino.hashCode(); // Incorpora el hash code del vértice de destino
        result = 31 * result + peso; // Incorpora el peso
        return result; // Devuelve el hash code resultante
    }

    @Override
    public String toString() {
        return "Arista{" + // Devuelve una cadena representando la arista y sus atributos
                "origen=" + origen +
                ", destino=" + destino +
                ", peso=" + peso +
                '}';
    }

    @Override
    public int compareTo(Arista<T> otra) {
        return Integer.compare(this.peso, otra.peso); // Compara las aristas por su peso
    }
}
