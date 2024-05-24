package org.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// Clase que implementa el algoritmo de Kruskal para encontrar el árbol de expansión mínima
public class Kruskal<T> {

    // Atributos
    private PriorityQueue<Arista<T>> aristas; // Cola de prioridad para ordenar las aristas

    // Constructor
    public Kruskal(List<Arista<T>> aristas, boolean ordenDescendente) {
        // Inicializar la cola de prioridad de acuerdo a si se requiere orden descendente
        if (ordenDescendente) {
            this.aristas = new PriorityQueue<>(Collections.reverseOrder());
            this.aristas.addAll(aristas); // Agregar todas las aristas a la cola de prioridad
        } else {
            this.aristas = new PriorityQueue<>(aristas); // Inicializar con las aristas proporcionadas
        }
    }

    // Método para procesar el árbol de expansión mínima con pesos mínimos
    public void procesarMinimo() {
        DisjointSet<T> ds = new DisjointSet<T>(); // Conjunto disjunto para realizar las uniones

        // Inicializar conjuntos disjuntos para cada vértice
        for (Arista<T> arista : aristas) {
            ds.makeSet(arista.getOrigen().getValor()); // Crear conjunto para el vértice de origen
            ds.makeSet(arista.getDestino().getValor()); // Crear conjunto para el vértice de destino
        }

        List<Arista<T>> resultado = new ArrayList<>(); // Almacenar el resultado final
        for (Arista<T> arista : aristas) {
            T origen = arista.getOrigen().getValor(); // Obtener el valor del vértice de origen
            T destino = arista.getDestino().getValor(); // Obtener el valor del vértice de destino
            if (ds.find(origen) != ds.find(destino)) {
                resultado.add(arista); // Agregar la arista al resultado
                ds.union(origen, destino); // Unir los conjuntos de los vértices de origen y destino
            }
        }

        // Imprimir el resultado
        for (Arista<T> arista : resultado) {
            System.out.println(arista.getOrigen().getValor() + " - " + arista.getDestino().getValor() + ": " + arista.getPeso());
        }
    }

    // Método para procesar el árbol de expansión mínima con pesos máximos
    public void procesarMaximo() {
        DisjointSet<T> ds = new DisjointSet<T>(); // Conjunto disjunto para realizar las uniones

        // Inicializar conjuntos disjuntos para cada vértice
        for (Arista<T> arista : aristas) {
            ds.makeSet(arista.getOrigen().getValor()); // Crear conjunto para el vértice de origen
            ds.makeSet(arista.getDestino().getValor()); // Crear conjunto para el vértice de destino
        }

        List<Arista<T>> resultado = new ArrayList<>(); // Almacenar el resultado final
        for (Arista<T> arista : aristas) {
            T origen = arista.getOrigen().getValor(); // Obtener el valor del vértice de origen
            T destino = arista.getDestino().getValor(); // Obtener el valor del vértice de destino
            if (ds.find(origen) != ds.find(destino)) {
                resultado.add(arista); // Agregar la arista al resultado
                ds.union(origen, destino); // Unir los conjuntos de los vértices de origen y destino
            }
        }

        // Imprimir el resultado en orden descendente de pesos
        for (int i = resultado.size() - 1; i >= 0; i--) {
            Arista<T> arista = resultado.get(i);
            System.out.println(arista.getOrigen().getValor() + " - " + arista.getDestino().getValor() + ": " + arista.getPeso());
        }
    }
}
