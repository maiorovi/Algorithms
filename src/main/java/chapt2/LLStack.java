package chapt2;

public class LLStack<Type> {

    private Node first;

    private class Node {
         Node next;
         Type value;
    }

    public void push(Type item) {
        Node temp = new Node();
        temp.value = item;
        temp.next = first;
        first = temp;
    }

    public Type pop() {
        Type value= first.value;
        first = first.next;
        return value;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
