import MyList.*;
import java.util.Iterator;

public class MyQueue<T extends Comparable<T>> implements Iterator<T> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<T>();
    }

    public T peek(){
        if (isEmpty()) {
            System.out.println("MyQueue is empty");
            return null;
        }
        return list.get(size() - 1);
    }

    public T enqueue(T item){
        list.add(item);
        return item;
    }

    public T dequeue(){
        if (isEmpty()) {
            System.out.println("MyQueue is empty");
            return null;
        }
        return list.remove(0);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public boolean hasNext() {
        return !isEmpty();
    }

    @Override
    public T next() {
        return dequeue();
    }
}
