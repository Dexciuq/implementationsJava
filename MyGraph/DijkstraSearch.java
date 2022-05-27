package MyGraph;

import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private final Set<T> unsettledNodes;
    private final Map <T, Double> distances;
    private final WeightedGraph<T> graph;

    public DijkstraSearch(WeightedGraph<T> graph, T source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;
        dijkstra();
    }

    public void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (unsettledNodes.size() > 0) {
            T node = getVertexWithMinimumWeight(unsettledNodes);
            marked.add(node);
            unsettledNodes.remove(node);
            for (T target : graph.adjacencyList(node)) {
                if (getShortestDistance(target) > getShortestDistance(node)
                        + getDistance(node, target)) {
                    distances.put(target, getShortestDistance(node)
                            + getDistance(node, target));
                    edgeTo.put(target, node);
                    unsettledNodes.add(target);
                }
            }
        }
    }

    private double getDistance(T node, T target) {
        for (Edge<T> edge : graph.getEdges(node)) {
            if (edge.getDest().equals(target))
                return edge.getWeight();
        }

        throw new RuntimeException("Not found!");
    }

    private T getVertexWithMinimumWeight(Set<T> vertices) {
        T minimum = null;
        for (T vertex : vertices) {
            if (minimum == null)
                minimum = vertex;
            else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum))
                    minimum = vertex;
            }
        }
        return minimum;
    }

    private double getShortestDistance(T destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}


