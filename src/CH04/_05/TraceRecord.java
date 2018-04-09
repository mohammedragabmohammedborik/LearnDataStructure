package CH04._05;

/**
 * Create by xong on 2018/4/9
 * 用于老鼠迷宫的行走路径
 */
class Node {
    int x;
    int y;
    Node next;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
public class TraceRecord {
    public Node first;
    public Node last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(int x, int y) {
        Node newNode = new Node(x, y);
        if (this.isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    public void delete() {
        Node newNode;
        if (this.isEmpty()) {
            System.out.println("队列已经空了");
            return;
        }
        newNode = first;
        while (newNode.getNext() != last) {
            newNode = newNode.getNext();
        }
        newNode.setNext(null);
        last = newNode;
    }
}
