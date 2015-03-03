package chapt5;

public class BinarySearchTree<K extends Comparable, T> {

    private Node root;

    public BinarySearchTree() {

    }

    private class Node {
        T value;
        K key;
        int N;
        Node left;
        Node right;

        Node(K key, T value, int N) {
            this.value = value;
            this.key = key;
        }
    }

    public T get(K key) {
        Node x = root;

        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp > 0) x = x.right;
            else if (cmp < 0) x = x.left;
            else              return x.value;
        }

        return null;
    }

    public void put(K key, T value) {
        root = put(root, key, value);
    }

    private Node put(Node x, K key, T value) {
        if (x == null)
            x = new Node(key, value, 1);

        int cmp = key.compareTo(x.key);

        if (cmp > 0)        x.right = put(x.right, key, value);
        else if (cmp < 0)   x.left = put(x.left, key, value);
        else                x.value = value;
        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    public int size(){
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }

    }

}
