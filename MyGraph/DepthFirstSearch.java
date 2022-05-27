package MyGraph;

public class DepthFirstSearch<T> extends Search<T> {
    public DepthFirstSearch(WeightedGraph<T> graph, T source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(WeightedGraph<T> graph, T current) {
        marked.add(current);
        count++;
        for (T vertex : graph.adjacencyList(current)) {
            if (!marked.contains(vertex)) {
                edgeTo.put(vertex, current);
                dfs(graph, vertex);
            }
        }
    }
}

