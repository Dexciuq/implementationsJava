package MyList;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {

    private Object[] arr;
    private int length = 0;
    private int capacity = 10;

    public MyArrayList() {
        arr = new Object[capacity];
    }

    @Override
    public void add(T item) {
        if (length == capacity)
            increaseCapacity();

        arr[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index should be positive and, less or equal to size");
        }
        if (length + 1 >= capacity) increaseCapacity();

        for (int i = length - 1; i >= index; i--){
            arr[i + 1] = arr[i];
        }
        arr[index] = item;
        length++;
    }

    @Override
    public boolean remove(T item) {
        int indexOfItem = indexOf(item);
        if (indexOfItem != -1) {
            remove(indexOfItem);
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("Index should be positive and less than size");
        }
        T returnedItem = (T)arr[index];

        for (int i = index; i < length - 1; i++){
            arr[i] = arr[i + 1];
        }
        arr[length - 1] = null;
        length--;

        return returnedItem;
    }

    @Override
    public void clear() {
        for (Object o : arr) o = null;
        length = 0;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index should be positive and less than size");
        }
        return (T)arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++){
            if (o.equals(arr[i])) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length - 1; i >= 0; i--){
            if (o.equals(arr[i])) return i;
        }
        return -1;
    }

    @Override
    public void sort() {
        Comparable<T> first, second;
        for (int i = 0; i < length - 1; i++) {
            first = (Comparable<T>) arr[i];
            for (int j = i + 1; j < length; j++) {
                second = (Comparable<T>) arr[j];
                if (first.compareTo((T)second) > 0){
                    T temp = (T) arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    first = second;
                }
            }
        }
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for (Object value : arr) {
            if (o.equals(value)) return true;
        }
        return false;
    }
}
