import MyList.*;

public class MyHeap<T extends Comparable<T>> {
    private final MyArrayList<T> list;

    public MyHeap(){
        list = new MyArrayList<T>();
    }

    public T getMin(){
        return list.get(0);
    }

    public void add(T item){
        list.add(item);
        traverseUp(size() - 1);
    }


    public T removeRoot(){
        list.swap(0,size() - 1);
        T item = list.remove(size() - 1);
        heapify(0);
        return item;
    }

    private void heapify(int index) {
        int left = leftChildOf(index), right, minimum;
        if (left >= size()) return;
        minimum = left;
        right = left + 1;
        if (right < size()){
            if (list.get(left).compareTo(list.get(right)) > 0){
                minimum++;
            }
        }
        if (list.get(minimum).compareTo(list.get(index)) < 0){
            list.swap(index, minimum);
            heapify(minimum);
        }
        else return;
    }

    private void traverseUp(int index){
        int parent;
        while (index > 0){
            parent = parentOf(index);
            if(list.get(parent).compareTo(list.get(index)) > 0){
                list.swap(index, parent);
                index = parent;
            }
            else break;
        }
    }

    private int leftChildOf(int index) {
        return index * 2 + 1;
    }

    private int rightChildOf(int index){
        return 2 * (index + 1);
    }

    private int parentOf(int index){
        return (index - 1) / 2;
    }

    public void printAll(){
        list.printAll();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }
}
