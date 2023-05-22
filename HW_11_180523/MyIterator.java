package HW_11_180523;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyIterator implements ListIterator<String> {
    private int cursor = 0;
    private Node first;
    private Node current = first;
    private Node lastReturned = null;

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        lastReturned = current;
        String result = current.data;
        current = current.next;
        cursor++;
        return result;
    }

    @Override
    public boolean hasPrevious() {
        return current != null && current.prev != null;
    }

    @Override
    public String previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        if (current == null) {
            Node last = null;
            current = last;
        } else {
            current = current.prev;
        }
        lastReturned = current;
        cursor--;
        return current.data;
    }

    @Override
    public int nextIndex() {
        return cursor;
    }

    @Override
    public int previousIndex() {
        return cursor - 1;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(String value) {
        if (lastReturned == null) {
            throw new IllegalStateException();
        }
        lastReturned.data = value;
    }

    @Override
    public void add(String value) {
        throw new UnsupportedOperationException();
    }
}
