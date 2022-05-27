package MyGraph;

import java.util.*;

public class BreadthFirstSearch<T> extends Search<T> {

    public BreadthFirstSearch(WeightedGraph<T> graph, T source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<T> graph, T current) {
        marked.add(current);
        Queue<T> queue = new LinkedList<>();
        queue.add(current);
        while (!queue.isEmpty()) {
            T vertex = queue.remove();
            for (T neighbor : graph.adjacencyList(vertex)) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, vertex);
                    queue.add(neighbor);
                }
            }
        }
    }
}

