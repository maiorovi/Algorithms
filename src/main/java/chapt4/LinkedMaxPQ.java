package chapt4;

public class LinkedMaxPQ<Type extends Comparable> implements PriorityQueue<Type>{

    private Node first;
    private int N;

    @Override
    public void insert(Type value) {
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.value = value;

        if (oldFirst != null)
            oldFirst.prev = first;
    }

    @Override
    public Type max() {
        return getMaxNode().value;
    }

    @Override
    public Type delMax() {
        Node max = getMaxNode();
        Type maxValue = max.value;
        max.prev = max.next;
        return maxValue;
    }

    private Node getMaxNode() {
        Node max = first;
        for (Node i = first.next; i.next != null; i = i.next) {
            if (less(max.value, i.value)) {
                max = i;
            }
        }

        return max;
    }

    private boolean less(Comparable val1, Comparable val2) {
        return val1.compareTo(val2) < 0;
    }

    private void exchAndRemoveFirstNode(Node second) {
        Node temp = first;
        first = second;
        second = temp;
        this.first = this.first.next;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    private class Node {
        Node next;
        Node prev;
        Type value;
    }
}
