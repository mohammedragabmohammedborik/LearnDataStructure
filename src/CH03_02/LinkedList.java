package CH03_02;

/**
 * Create by xong on 2018/4/8
 */
public class LinkedList {
    public Node first;
    public Node last;

    public boolean isEmpty() {
        return first == null;
    }

    // 输出
    public void print() {
        Node current = first;
        while (current != null) {
            System.out.println("[" + current.data + "," + current.names + "," + current.np + "]");
            current = current.next;
        }
        System.out.println();
    }

    // 链表反转
    public void reverse_print() {
        Node current = reverse(first);
        while (current != null) {
            System.out.println("[" + current.data + "," + current.names + "," + current.np + "]");
            current = current.next;
        }
    }

    private Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找到最后一个节点
        Node reHead = reverse(head.next);
        // 反转
        head.next.next = head;
        head.next = null;
        return reHead;
    }

    // 插入
    public void insert(int data, String names, int np) {
        Node newNode = new Node(data, names, np);
        if (this.isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    public void insert(Node ptr) {
        Node temp;
        Node newNode;
        if (this.isEmpty()) {
            first = ptr;
            last = ptr;
        } else {
            if (ptr.next == first) {
                first = ptr;
            } else {
                if (ptr.next == null) {
                    last.next = ptr;
                    last = ptr;
                } else {
                    newNode = first;
                    temp = first;
                    while (ptr.next != newNode.next) {
                        temp = newNode;
                        newNode = newNode.next;
                    }
                    temp.next = ptr;
                    ptr.next = newNode;
                }
            }
        }
    }

    // 删除
    public void delete(Node delNode) {
        Node newNode ;
        Node temp ;
        if (first.data == delNode.data) {
            first = first.next;
        } else if (last.data == delNode.data) {
            newNode = last;
            // 遍历链表将最后一个节点找出
            while (newNode.next != last) {
                newNode = newNode.next;
            }
            // .next是最后一个节点，将节点置为null
            newNode.next = null;
            // 更新last
            last = newNode;
        } else {
            newNode = first;
            temp = first;
            while (newNode.data != delNode.data) {
                temp = newNode;
                newNode = newNode.next;
            }
            temp.next = delNode.next;
        }
    }
}

class Node {
    int data;
    int np;
    String names;
    Node next;

    public Node(int data, String names, int np) {
        this.np = np;
        this.names = names;
        this.data = data;
        this.next = null;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}