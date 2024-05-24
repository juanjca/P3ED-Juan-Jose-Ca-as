package org.kruskal;

import java.util.HashSet;
import java.util.Set;

// Clase Genérica que representa un vértice en un grafo
public class Vertice<T> {

    // Atributos
    private final T valor; // Valor del vértice
    private final Set<Vertice<T>> verticesVecinos; // Conjunto de vecinos del vértice
    private boolean visitado; // Indica si el vértice ha sido visitado
    private boolean exploracion; // Indica si el vértice está siendo explorado

    // Constructor
    public Vertice(T valor) {
        this.valor = valor; // Inicializa el valor del vértice
        this.verticesVecinos = new HashSet<>(); // Inicializa el conjunto de vecinos
        this.visitado = false; // Inicializa el vértice como no visitado
        this.exploracion = false; // Inicializa el vértice como no explorado
    }

    // Métodos

    public T getValor() {
        return valor; // Devuelve el valor del vértice
    }

    public void agregarVecino(Vertice<T> vecino) {
        verticesVecinos.add(vecino); // Agrega un vecino al conjunto de vecinos
    }

    public Set<Vertice<T>> getVerticesVecinos() {
        return verticesVecinos; // Devuelve el conjunto de vecinos
    }

    public boolean visitado() {
        return visitado; // Devuelve si el vértice ha sido visitado
    }

    public void visitadoTrue() {
        visitado = true; // Marca el vértice como visitado
    }

    public boolean explorando() {
        return exploracion; // Devuelve si el vértice está siendo explorado
    }

    public void definirExploracion(boolean valor) {
        exploracion = valor; // Establece el estado de exploración
    }

    @Override
    public int hashCode() {
        return valor.hashCode(); // Devuelve el código hash del vértice
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Compara si los objetos son iguales
        if (!(obj instanceof Vertice)) return false; // Verifica la instancia
        Vertice<?> otroVertice = (Vertice<?>) obj; // Casteo seguro
        return valor.equals(otroVertice.valor); // Compara los valores
    }

    @Override
    public String toString() {
        return valor.toString(); // Devuelve el valor como cadena
    }
}
