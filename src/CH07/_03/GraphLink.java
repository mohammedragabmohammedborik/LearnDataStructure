package CH07._03;

/**
 * Create by xong on 2018/4/12
 */
class Node {
    int x;
    Node next;

    public Node(int value) {
        this.x = value;
        this.next = null;
    }
}
public class GraphLink {
    public Node first;
    public Node last;

    public boolean isEmpty() {
        return first == null;
    }

    public void print() {
        Node current = first;

        while (current !=null) {
            System.out.print("[" + current.x + "] ");
            current = current.next;
        }
        System.out.println();
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (this.isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
    }
}
