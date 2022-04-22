import MyList.*;

public class MyStack<T extends Comparable<T>> {
    private final MyList<T> list;

    public MyStack() {
        list = new MyArrayList<T>();
    }

    public T push(T item){
        list.add(item);
        return item;
    }

    public T peek(){
        if (isEmpty()) {
            System.out.println("MyStack is empty");
            return null;
        }
        return list.get(size() - 1);
    }

    public T pop(){
        if (isEmpty()) {
            System.out.println("MyStack is empty");
            return null;
        }
        return list.remove(size() - 1);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }
}
