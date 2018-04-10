package CH05._03;

/**
 * Create by xong on 2018/4/10
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
    public Node front; // 队列前端指针
    public Node rear; // 队列尾端指针

    public void enqueue(int value) {
        Node node = new Node(value);
        // 判断是否是空队列
        if (rear == null) {
            front = node;
        } else {
            rear.next = node;
        }
        rear = node;
    }

    public int dequeue(int action) {
        int value;
        Node temp, start;
        // 从前端取出数据
        if (!(front == null) && action == 1) {
            if (front == rear) {
                rear = null;
            }
            value = front.data;// 将数据从前端取出
            // 更新队头
            front = front.next;
            return value;
        } else if (!(rear == null) && action == 2) {
            // 从尾端取出数据
            start = front;
            // 队尾的值
            value = rear.data;
            temp = front;
            // 更新队尾
            while (front.next != rear && front.next != null) {
                front = front.next;
                temp = front;
            }
            front = start;
            rear = temp;
            if ((front.next == null) || (rear.next == null)) {
                front = null;
                rear = null;
            }
            return value;
        } else {
            return -1;
        }

    }
}
