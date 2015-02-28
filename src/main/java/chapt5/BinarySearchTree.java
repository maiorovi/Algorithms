package chapt5;

public class BinarySearchTree<T,K extends Comparable> {

    public BinarySearchTree() {

    }

    private class Node {
        T value;
        K key;
        Node left;
        Node right;

        Node(K key, T value) {
            this.value = value;
            this.key = key;
        }
    }

}
