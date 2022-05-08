import java.util.Iterator;

public class MyBST<K extends Comparable<K>, V> implements Iterable<K>{
    private Node root;
    private class Node{
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    public MyBST(){
        root = null;
    }

    public void put(K key, V value){
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value){
        if (node == null) {
            node = new Node(key, value);
        }
        else if (key.compareTo(node.key) > 0) {
            node.right = put(node.right, key, value);
        }
        else if (key.compareTo(node.key) < 0){
            node.left = put(node.left, key, value);
        }
        else {
            node.value = value;
        }
        return node;
    }

    public V get(K key){
        Node node = root;
        while (node != null){
            if (key.compareTo(node.key) == 0) return node.value;
            if (key.compareTo(node.key) < 0) node=node.left;
            else node=node.right;
        }
        return (V) "No such KEY in BST";
    }

    public void delete(K key){
        delete(root, key);
    }

    private Node delete(Node node, K key){
        if (node == null) {
            System.out.println("No such KEY in BST");
            return null;
        }

        if (key.compareTo(node.key) < 0){
            node.left = delete(node.left, key);
        }
        else if (key.compareTo(node.key) > 0){
            node.right = delete(node.right, key);
        }

        else {
            if (node.left == null){
                return node.right;
            }
            else if (node.right == null){
                return node.left;
            }
            node = getMax(node.left);
            node.left = delete(node.left, node.key);
        }

        return node;
    }

    public V getMax(){
        return getMax(root).value;
    }
    private Node getMax(Node root){
        if (root == null) return null;
        Node node = root;
        while (node.right != null){
            node = node.right;
        }
        return node;
    }

    public V getMin(){
        return getMin(root).value;
    }
    private Node getMin(Node root){
        if (root == null) return null;
        Node node = root;
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public Iterator<K> iterator(){
        MyQueue<K> myQueue = new MyQueue<K>();
        inOrder(root, myQueue);
        return myQueue;
    }

    private void inOrder(Node current, MyQueue<K> myQueue){
        if (current == null) return;
        inOrder(current.left, myQueue);
        myQueue.enqueue(current.key);
        inOrder(current.right, myQueue);
    }
}
