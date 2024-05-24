package org.kruskal;

import java.util.HashMap;
import java.util.Map;

// Clase que implementa un Conjunto Disjunto (Disjoint Set) o Unión-Find
public class DisjointSet<T> {

    // Atributos
    private Map<T, T> parent = new HashMap<>(); // Mapa que almacena el padre de cada elemento
    private Map<T, Integer> rank = new HashMap<>(); // Mapa que almacena el rango de cada elemento

    // Método para crear un conjunto para un nuevo elemento
    public void makeSet(T item) {
        parent.put(item, item); // Inicializa el padre del elemento como él mismo
        rank.put(item, 0); // Inicializa el rango del elemento como 0
    }

    // Método para encontrar el representante (raíz) del conjunto que contiene el elemento
    public T find(T item) {
        if (!parent.get(item).equals(item)) {
            parent.put(item, find(parent.get(item))); // Compresión de caminos
        }
        return parent.get(item); // Devuelve el representante del conjunto
    }

    // Método para unir dos conjuntos
    public void union(T set1, T set2) {
        T root1 = find(set1); // Encuentra la raíz del primer conjunto
        T root2 = find(set2); // Encuentra la raíz del segundo conjunto

        if (!root1.equals(root2)) {
            int rank1 = rank.get(root1); // Obtiene el rango de la raíz del primer conjunto
            int rank2 = rank.get(root2); // Obtiene el rango de la raíz del segundo conjunto

            // Une los conjuntos basándose en el rango
            if (rank1 > rank2) {
                parent.put(root2, root1); // El conjunto con menor rango apunta al de mayor rango
            } else if (rank1 < rank2) {
                parent.put(root1, root2); // El conjunto con menor rango apunta al de mayor rango
            } else {
                parent.put(root2, root1); // Si los rangos son iguales, uno apunta al otro y se incrementa el rango
                rank.put(root1, rank1 + 1);
            }
        }
    }
}
