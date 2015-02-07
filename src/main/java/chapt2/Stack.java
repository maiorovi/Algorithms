package chapt2;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Item[] items;
    private int pointer = 0;

    public Stack(int capacity) {
        items = (Item[]) new Object[capacity];
    }

    public void push(Item item) {
        if (pointer == items.length ) {
            resize(items, items.length * 2);
        }
        items[pointer++] =  item;
    }

    public Item pop() {
        if (pointer < items.length / 4) {
            resize(items, items.length / 2);
        }
        return items[--pointer];
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    private void resize(Item[] items, int newSize) {
        Item[] tempItems = (Item []) new Object[newSize];
        for (int i = 0; i < items.length; i++ ) {
            tempItems[i] = items[i];
        }
        items = tempItems;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {

        private int itPointer;

        @Override
        public boolean hasNext() {
            return itPointer < items.length;
        }

        @Override
        public Item next() {
            return items[itPointer++];
        }

        @Override
        public void remove() {
            //
        }
    }
}
