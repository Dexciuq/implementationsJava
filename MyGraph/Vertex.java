package MyGraph;

import java.util.*;

public class Vertex<T> {
    private final T data;
    private final Map <Vertex<T>, Double> adjacentVertices;

    public Vertex(T data){
        this.data = data;
        adjacentVertices = new HashMap<>();
    }

    public T getData(){
        return data;
    }

    public int getSize(){
        return adjacentVertices.size();
    }

    public Map <Vertex<T>, Double> getVertices(){
        return adjacentVertices;
    }
    public void addVertex(T dest, double weight){
        adjacentVertices.put(new Vertex<>(dest), weight);
    }

    public boolean containsVertex(Vertex<T> vertex){
        return adjacentVertices.containsKey(vertex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }
}