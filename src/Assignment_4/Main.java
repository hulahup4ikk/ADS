package Assignment_4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 5);
        graph.addEdge("B", "D", 10);
        graph.addEdge("C", "D", 3);
        graph.addEdge("D", "E", 4);

        System.out.println("=== BFS Path from A to E ===");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "A");
        System.out.println(bfs.getPath("A", "E"));

        System.out.println("=== Dijkstra Path from A to E ===");
        Search<String> dijkstra = new DijkstraSearch<>(graph, "A");
        System.out.println(dijkstra.getPath("A", "E"));
    }
}

