package CH05._02;

/**
 * Create by xong on 2018/4/10
 * 环形队列
 */

class Node {
    int data;
    public Node(int data) {
        this.data = data;
    }
}

public class LoopListLink {
    public Node[] elementData;
    private int front = 0; // 队头
    private int rear = 0; // 队尾
    private int size = 0; // 数组大小

    public LoopListLink(int size) {
        // 初始化队列大小
        this.size = size;
        elementData = new Node[size];
    }

    // 获取循环队列大小
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return rear > front ? rear - front : size - (front - rear);
    }

    // 加入队列
    public void add(Node node) {
        // 队列已满
        if (rear == front && elementData[rear] != null) {
            System.out.println("队列已满");
        } else {
            elementData[rear++] = node;
            // 判断是否到头
            rear = rear == size ? 0 : rear;
        }
    }

    // 移除队列
    public Node remove() {
        // 判断是否是空队列
        if (isEmpty()) {
            return null;
        }
        // 得到队头
        Node oldNode = elementData[front];
        // 在队列中置为null
        elementData[front++] = null;
        // 判断front是否到头
        front = front == size ? 0 : front;
        return oldNode;
    }

    // 返回队列顶端元素，但是不remove
    public Node element() {
        if (isEmpty()) {
            return null;
        }
        return elementData[front];
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front && elementData[rear] == null;
    }

    @Override
    public String toString() {
        String st = "";
        for (int i = 0; i < elementData.length; i++) {
            Node node = elementData[i];
            if (node == null) {
                continue;
            }
            st += i + "的值为" + node.data + "\n";
        }
        return st;
    }
}
