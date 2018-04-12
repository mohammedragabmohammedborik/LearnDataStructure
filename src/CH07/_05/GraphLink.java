package CH07._05;

/**
 * Create by xong on 2018/4/12
 */
class Node {
    int value;
    Node next;
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
public class GraphLink {
    public Node first;
    public Node last;

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.print("[" + current.value + "] ");
            current = current.next;
        }
        System.out.println();
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
    }
}
