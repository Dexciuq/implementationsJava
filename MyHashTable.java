public class MyHashTable<K, V> {
    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
            next = null;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V> [] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(){
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value){
        int hashIndex = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if (chainArray[hashIndex] != null){
            newNode.next = chainArray[hashIndex];
        }
        chainArray[hashIndex] = newNode;
    }

    public V get(K key){
        int hashIndex = hash(key);
        HashNode<K, V> current = chainArray[hashIndex];
        while (current != null){
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }
        return (V) "No such KEY in HashTable";
    }

    public V remove(K key){
        int hashIndex = hash(key);
        HashNode<K, V> current = chainArray[hashIndex];
        HashNode<K, V> prev = null;

        while (current != null){
            if (key.equals(current.key)){
                if (chainArray[hashIndex].equals(current)){
                    chainArray[hashIndex] = current.next;
                }
                else {
                    prev.next = current.next;
                }
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return (V) "No such KEY in HashTable";
    }

    public boolean contains(V value){
        HashNode <K, V> node;
        for (int i = 0; i < M; i++){
            node = chainArray[i];
            while (node != null){
                if (node.value.equals(value)) return true;
                node = node.next;
            }
        }
        return false;
    }

    public K getKey(V value){
        HashNode <K, V> node;
        for (int i = 0; i < M; i++){
            node = chainArray[i];
            while (node != null){
                if (node.value.equals(value)) return node.key;
                node = node.next;
            }
        }
        return (K) "No such VALUE in HashTable";
    }
}
