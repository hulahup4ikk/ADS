package Assignment_4;

import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<V, V> visited = new HashMap<>();

    public BreadthFirstSearch(WeightedGraph<V> graph, V start) {
        Queue<V> queue = new LinkedList<>();
        queue.add(start);
        visited.put(start, null);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            Vertex<V> currentVertex = graph.getVertex(current);
            if (currentVertex == null) continue;

            for (Map.Entry<Vertex<V>, Double> entry : currentVertex.getAdjacentVertices().entrySet()) {
                V neighbor = entry.getKey().getData();
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<V> getPath(V start, V end) {
        List<V> path = new LinkedList<>();
        if (!visited.containsKey(end)) return path; // no path

        for (V at = end; at != null; at = visited.get(at)) {
            path.add(0, at);
        }
        return path;
    }
}

