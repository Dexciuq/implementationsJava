package MyGraph;

import java.util.*;
public class Graph<T>{
    private final boolean undirected;
    private final Map<T, Vertex<T>> graph;

    public Graph() {
        this(true);
    }

    public Graph(boolean undirected) {
        this.undirected = undirected;
        graph = new HashMap<>();
    }

    public void addVertex(T data) {
        graph.put(data, new Vertex<>(data));
    }

    public void addEdge(T source, T dest) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return;

        graph.get(source).addVertex(dest, 0);

        if (undirected)
            graph.get(dest).addVertex(source, 0);
    }

    public int getVerticesCount() {
        return graph.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (T vertex : graph.keySet()) {
            count += graph.get(vertex).getSize();
        }
        if (undirected) count /= 2;
        return count;
    }


    public boolean hasVertex(T vertex) {
        return graph.containsKey(vertex);
    }

    public boolean hasEdge(T source, T dest) {
        if (!hasVertex(source)) return false;
        return graph.get(source).containsVertex(new Vertex<>(dest));
    }

    public Iterable<T> adjacencyList(T vertex) {
        if (!hasVertex(vertex)) return null;
        List<T> vertices = new LinkedList<>();
        for (Vertex<T> edge : graph.get(vertex).getVertices().keySet()) {
            vertices.add(edge.getData());
        }
        return vertices;
    }
}

