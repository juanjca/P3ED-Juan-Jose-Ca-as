package org.kruskal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Clase de utilidades para operar sobre grafos
public class Utils<T> {

    // Método para verificar si un grafo no dirigido tiene ciclos
    public boolean tieneCicloGrafoNoDirigido(List<Vertice<T>> grafo) {
        Set<Vertice<T>> visitados = new HashSet<>(); // Conjunto para almacenar los vértices visitados
        for (Vertice<T> vertice : grafo) {
            if (!visitados.contains(vertice) && tieneCicloDFS(vertice, visitados, null)) {
                return true; // Retorna true si se encuentra un ciclo
            }
        }
        return false; // Retorna false si no se encuentran ciclos
    }

    // Método privado auxiliar para la detección de ciclos en grafos no dirigidos mediante DFS
    private boolean tieneCicloDFS(Vertice<T> actual, Set<Vertice<T>> visitados, Vertice<T> padre) {
        visitados.add(actual); // Marca el vértice actual como visitado
        for (Vertice<T> vecino : actual.getVerticesVecinos()) {
            if (!visitados.contains(vecino)) {
                if (tieneCicloDFS(vecino, visitados, actual)) {
                    return true; // Retorna true si se encuentra un ciclo
                }
            } else if (vecino != padre) {
                return true; // Retorna true si se encuentra un ciclo que no pasa por el padre
            }
        }
        return false; // Retorna false si no se encuentra un ciclo
    }

    // Método para verificar si un grafo dirigido tiene ciclos
    public boolean tieneCicloGrafoDirigido(List<Vertice<T>> grafo) {
        Set<Vertice<T>> visitados = new HashSet<>(); // Conjunto para almacenar los vértices visitados
        Set<Vertice<T>> enRecursion = new HashSet<>(); // Conjunto para almacenar los vértices en la pila de recursión
        for (Vertice<T> vertice : grafo) {
            if (tieneCicloDFSDirigido(vertice, visitados, enRecursion)) {
                return true; // Retorna true si se encuentra un ciclo
            }
        }
        return false; // Retorna false si no se encuentran ciclos
    }

    // Método privado auxiliar para la detección de ciclos en grafos dirigidos mediante DFS
    private boolean tieneCicloDFSDirigido(Vertice<T> actual, Set<Vertice<T>> visitados, Set<Vertice<T>> enRecursion) {
        if (enRecursion.contains(actual)) {
            return true; // Retorna true si el vértice actual está en la pila de recursión (ciclo encontrado)
        }
        if (visitados.contains(actual)) {
            return false; // Retorna false si el vértice actual ya fue visitado y no está en la pila de recursión
        }
        visitados.add(actual); // Marca el vértice actual como visitado
        enRecursion.add(actual); // Añade el vértice actual a la pila de recursión
        for (Vertice<T> vecino : actual.getVerticesVecinos()) {
            if (tieneCicloDFSDirigido(vecino, visitados, enRecursion)) {
                return true; // Retorna true si se encuentra un ciclo
            }
        }
        enRecursion.remove(actual); // Remueve el vértice actual de la pila de recursión
        return false; // Retorna false si no se encuentra un ciclo
    }
}
