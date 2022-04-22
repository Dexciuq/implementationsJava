import MyList.*;

public class MyHeap<T extends Comparable<T>> {
    private final MyList<T> list;

    public MyHeap(){
        list = new MyArrayList<T>();
    }

    private void heapify(){

    }

    public void add(T item){
        list.add(item);
    }

    public T removeRoot(){

        return null;
    }

    public boolean remove(T item){
        return true;
    }
}
