package CH05._01;

/**
 * Create by xong on 2018/4/10
 * 实现以链表建立队列
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class QueueListLink {
    public Node front; // 队列的前端指针
    public Node rear; // 队列的尾端指针

    // 插入队列
    public void enqueue(int value) {
        Node node = new Node(value);
        // 检测是否为空队列
        if (rear == null) {
            front = node;
        } else {
            rear.next = node;
        }
        rear = node;
    }

    // 取出
    public int dequeue() {
        int value;
        // 判断队列是否为空
        if (!(front == null)) {
            // 判断是否只有一个节点
            if (front == rear) {
                rear = null;
            }
            value = front.data;
            front = front.next;
            return value;
        } else {
            return -1;
        }
    }
}
