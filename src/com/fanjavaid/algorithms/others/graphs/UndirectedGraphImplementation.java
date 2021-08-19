package com.fanjavaid.algorithms.others.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class UndirectedGraph {
    Map<String, List<String>> adjacencyList;

    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(String vertex1, String vertex2) {
        if (adjacencyList.containsKey(vertex1)) {
            adjacencyList.get(vertex1).add(vertex2);
        }

        if (adjacencyList.containsKey(vertex2)) {
            adjacencyList.get(vertex2).add(vertex1);
        }
    }

    public void removeEdge(String vertex1, String vertex2) {
        if (adjacencyList.containsKey(vertex1)) {
            // Using java 8 streams lambda to filter and replace current vertex1 values
            adjacencyList.replace(vertex1, adjacencyList.get(vertex1)
                    .stream()
                    .filter(v -> !v.equals(vertex2))
                    .collect(Collectors.toList()));
        }

        if (adjacencyList.containsKey(vertex2)) {
            // Using java 8 streams lambda to filter and replace current vertex2 values
            adjacencyList.replace(vertex2, adjacencyList.get(vertex2)
                    .stream()
                    .filter(v -> !v.equals(vertex1))
                    .collect(Collectors.toList()));
        }
    }

    public void removeVertex(String vertex) {
        if (adjacencyList.containsKey(vertex)) {
            List<String> adjacentVertex = adjacencyList.get(vertex);
            adjacencyList.remove(vertex);
            for (String s : adjacentVertex) removeEdge(vertex, s);
        }
    }

    @Override
    public String toString() {
        return adjacencyList.toString();
    }
}

public class UndirectedGraphImplementation {
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();
        graph.addVertex("Tokyo");
        graph.addVertex("Jakarta");
        graph.addVertex("Perth");

        graph.addEdge("Tokyo", "Jakarta");
        graph.addEdge("Jakarta", "Perth");
        System.out.println(graph);

        graph.removeEdge("Jakarta", "Perth");
        System.out.println(graph);

        graph.addVertex("Hongkong");
        graph.addVertex("Bangkok");
        graph.addEdge("Jakarta", "Hongkong");
        graph.addEdge("Hongkong", "Bangkok");
        System.out.println(graph);

        graph.removeVertex("Jakarta");
        System.out.println(graph);
    }
}
