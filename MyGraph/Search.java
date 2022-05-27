package MyGraph;

import java.util.*;

public class Search<T> {
    protected int count;
    protected Set<T> marked;
    protected Map<T, T> edgeTo;
    protected final T source;

    public Search(T source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(T vertex) {
        return marked.contains(vertex);
    }

    public Iterable<T> pathTo(T vertex) {
        if (!hasPathTo(vertex)) return null;
        LinkedList<T> ls = new LinkedList<>();
        for (T i = vertex; i != source; i = edgeTo.get(i)) {
            ls.push(i);
        }
        ls.push(source);

        return ls;
    }

    public int getCount() {
        return count;
    }
}

