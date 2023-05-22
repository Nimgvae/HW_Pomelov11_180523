package HW_11_180523;

public class Node {
    public String data;
    public Node next;
    Node prev;
    public Node(String data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

}
