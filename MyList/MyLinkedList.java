package MyList;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;
        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;
    public MyLinkedList() {}

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        if (index > length || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);

        if (index == length) add(item);
        else {
            MyNode<T> currentNode = head, newNode = new MyNode<>(item);

            while (index != 0) {
                currentNode = currentNode.next;
                index--;
            }

            newNode.prev = currentNode.prev;
            if (newNode.prev != null) newNode.prev.next = newNode;
            else head = newNode;
            newNode.next = currentNode;
            currentNode.prev = newNode;

            length++;
        }
    }

    @Override
    public boolean remove(T item) {
        int indexOfItem = indexOf(item);
        if (indexOfItem != -1){
            remove(indexOfItem);
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index >= length || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);

        MyNode<T> currentNode = head;
        while (index != 0) {
           currentNode = currentNode.next;
           index--;
        }
        T returnedItem = (T) currentNode;

        if (currentNode.prev != null) currentNode.prev.next = currentNode.next;
        else head = head.next;
        if (currentNode.next != null) currentNode.next.prev = currentNode.prev;
        else tail = tail.prev;
        length--;

        return returnedItem;
    }

    @Override
    public void clear() {
        MyNode<T> currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
            currentNode.prev = null;
        }
        head = tail = null;
        length = 0;
    }

    @Override
    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("Index should be positive and less than size");

        MyNode<T> temp = head;
        while (index != 0) {
            temp = temp.next;
            index--;
        }
        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        MyNode<T> currentNode = head;
        int index = 0;
        while (currentNode != null){
            if (currentNode.data.equals(o)) return index;
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyNode<T> currentNode = tail;
        int index = length - 1;
        while (currentNode != null){
            if (currentNode.data.equals(o)) return index;
            currentNode = currentNode.prev;
            index--;
        }
        return -1;
    }

    @Override
    public void sort() {
        MyNode<T> node = head;
        Comparable<T> first, second;
        for (MyNode<T> i = head; i.next != null; i = i.next) {
            first = (Comparable<T>) i.data;
            for (MyNode<T> j = i.next; j != null; j = j.next) {
                second = (Comparable<T>) j.data;
                if (first.compareTo((T) second) > 0){
                    T temp = i.data;
                    i.data = j.data;
                    j.data = temp;
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
        MyNode<T> currentNode = head;
        while (currentNode != null){
            if (currentNode.data.equals(o)) return true;
            currentNode = currentNode.next;
        }
        return false;
    }
}
