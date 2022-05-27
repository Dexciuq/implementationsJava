package MyGraph;

import java.util.*;

public class Edge<T> {
    private T source;
    private T dest;
    private Double weight;

    public Edge(T source, T dest, Double weight) {
        this(source, dest);
        setWeight(weight);
    }

    public Edge(T source, T dest) {
        setSource(source);
        setDest(dest);
    }

    public void setSource(T source) {
        this.source = source;
    }

    public T getSource() {
        return source;
    }

    public void setDest(T dest) {
        this.dest = dest;
    }

    public T getDest() {
        return dest;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(source, edge.source) &&
                Objects.equals(dest, edge.dest);
    }
}