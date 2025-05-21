package Assignment_4;

import java.util.*;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices = new HashMap<>();

    public void addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest, double weight) {
        addVertex(source);
        addVertex(dest);
        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);
        sourceVertex.addAdjacentVertex(destVertex, weight);
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Collection<Vertex<V>> getVertices() {
        return vertices.values();
    }
}
