package HW_11_180523;

import java.util.Iterator;

public class MyLinkedList implements Iterable<String> {

    private int size = 0;
    private Node first;
    private Node last;

    public void clear() {
        size = 0;
        first = null;
    }
    public MyLinkedList() {
        size = 0;
        first = null;
        last = null;
    }
    public void add(String value) {
        if (isEmpty()) {
            Node newNode = new Node(value, null, null);
            first = newNode;
            last = newNode;
        } else {
            Node newNode = new Node(value, null, last);
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

//    public void add(String value) {
//        if (isEmpty()) {
//            first = new Node(value, null);
//        } else {
//            Node current = first;
//            for (int i = 0; i < size - 1; i++) {
//                current = current.next;
//            }
//            Node newNode = new Node(value, null);
//            current.next = newNode;
//        }
//        size++;
//    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        // AAA BBB CCC - [AAA, BBB, CCC]
        StringBuilder builder = new StringBuilder("[");
        Node current = first;
        while (current != null) {
            builder.append(current.data).append(", ");
            current = current.next;
        }
        builder.setLength(builder.length() - 2);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }
//    private void test() {
//        Node node = new Node("Test", null);
//        // Почему нам не нужны геттеры и сеттеры.
//        // Мы имеем прямой доступ к приватным полям внутреннего класса.
//        node.data = "";
//    }

    public class MyIterator implements Iterator<String> {
        private int cursor = 0;
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            String result = current.data;
            current = current.next;
            return result;
        }
    }

    private class Node {

        private String data;
        private Node next;

        public Node(String data, Node next, Object o) {
            this.data = data;
            this.next = next;
        }
    }
}