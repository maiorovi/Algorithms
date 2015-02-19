package chapt4;

import java.util.Comparator;

public class LinkedMaxPQ<Type extends Comparable> implements PriorityQueue<Type>{

    private Node first;
    private int N;

    @Override
    public void insert(Type value) {
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.value = value;
        N++;
    }

    @Override
    public Type max() {
        return getMaxNode().value;
    }

    @Override
    public Type delMax() {
        Node max = getMaxNode();
        Type maxValue = max.value;
        exch(max);
        first = first.next;
        N--;

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

    private void exch(Node n) {
        Node temp = first;
        first.value = n.value;
        n.value = first.value;
    }


    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    private class Node {
        Node next;
        Type value;
    }
}
