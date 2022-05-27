package MyGraph;

import java.util.*;

public class WeightedGraph<T> {
    private final boolean undirected;
    private final Map <T, Vertex<T>> weightedGraph;

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        weightedGraph = new HashMap<>();
    }

    public void addVertex(T data) {
        weightedGraph.put(data, new Vertex<>(data));
    }

    public void addEdge(T source, T dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return;

        weightedGraph.get(source).addVertex(dest, weight);

        if (undirected)
            weightedGraph.get(dest).addVertex(source, weight);
    }

    public int getVerticesCount() {
        return weightedGraph.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (T vertex : weightedGraph.keySet()) {
            count += weightedGraph.get(vertex).getSize();
        }
        if (undirected) count /= 2;
        return count;
    }


    public boolean hasVertex(T vertex) {
        return weightedGraph.containsKey(vertex);
    }

    public boolean hasEdge(T source, T dest) {
        if (!hasVertex(source)) return false;
        return weightedGraph.get(source).containsVertex(new Vertex<>(dest));
    }

    public Iterable<T> adjacencyList(T vertex) {
        if (!hasVertex(vertex)) return null;
        List<T> vertices = new LinkedList<>();
        for (Vertex<T> edge : weightedGraph.get(vertex).getVertices().keySet()) {
            vertices.add(edge.getData());
        }
        return vertices;
    }

    public Iterable<Edge<T>> getEdges(T data) {
        if (!hasVertex(data)) return null;
        List<Edge<T>> edges = new LinkedList<>();
        for (Vertex<T> vertex : weightedGraph.get(data).getVertices().keySet()){
            edges.add(new Edge<T>(data, vertex.getData(), weightedGraph.get(data).getVertices().get(vertex)));
        }
        return edges;
    }

}
