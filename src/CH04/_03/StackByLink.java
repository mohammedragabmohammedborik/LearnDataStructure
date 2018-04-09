package CH04._03;

/**
 * Create by xong on 2018/4/9
 */
class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
public class StackByLink {
    public Node front;
    public Node rear;

    // 判断是否是空堆栈
    public boolean isEmpty() {
        return front == null;
    }

    // 打印堆栈
    public void outputOfStack() {
        Node current = front;
        while (current != null) {
            System.out.print("[" + current.data + "]");
            current = current.getNext();
        }
        System.out.println();
    }

    // 压入堆栈
    public void insert(int data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            front = newNode;
            rear = front;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    // 出栈
    public void pop() {
        Node newNode;
        if (this.isEmpty()) {
            System.out.println("目前的堆栈是空的");
            return;
        }
        newNode = front;
        // 当栈顶和栈底相同时，则置为null
        if (newNode == rear) {
            front = null;
            rear = null;
        } else {
            // 寻找栈顶，其实就是寻找链表的尾节点
            while (newNode.getNext() != rear) {
                newNode = newNode.getNext();
            }
            newNode.setNext(rear.getNext());
            rear = newNode;
        }
    }
}
