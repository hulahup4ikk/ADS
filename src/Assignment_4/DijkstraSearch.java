package Assignment_4;

import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private Map<V, V> predecessors = new HashMap<>();
    private Map<V, Double> distances = new HashMap<>();

    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        PriorityQueue<VertexDistance<V>> pq = new PriorityQueue<>();
        pq.add(new VertexDistance<>(start, 0.0));
        distances.put(start, 0.0);

        while (!pq.isEmpty()) {
            VertexDistance<V> current = pq.poll();
            V currentVertexData = current.vertex;
            Vertex<V> currentVertex = graph.getVertex(currentVertexData);
            if (currentVertex == null) continue;

            for (Map.Entry<Vertex<V>, Double> entry : currentVertex.getAdjacentVertices().entrySet()) {
                V neighbor = entry.getKey().getData();
                double newDist = distances.getOrDefault(currentVertexData, Double.MAX_VALUE) + entry.getValue();

                if (newDist < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    predecessors.put(neighbor, currentVertexData);
                    pq.add(new VertexDistance<>(neighbor, newDist));
                }
            }
        }
    }

    @Override
    public List<V> getPath(V start, V end) {
        List<V> path = new ArrayList<>();
        if (!distances.containsKey(end)) return path;

        for (V at = end; at != null; at = predecessors.get(at)) {
            path.add(0, at);
        }
        return path;
    }

    private static class VertexDistance<V> implements Comparable<VertexDistance<V>> {
        V vertex;
        double distance;

        VertexDistance(V vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(VertexDistance<V> o) {
            return Double.compare(this.distance, o.distance);
        }
    }
}
