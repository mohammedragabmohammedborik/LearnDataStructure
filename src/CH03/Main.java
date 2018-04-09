package CH03;

/**
 * Create by xong on 2018/4/8
 */
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.insert(i, "name" + i, 1000 + i);
        }
        System.out.println("链表原始状态");
        list.print();
        System.out.println("删除头结点");
        Node current1 = new Node(list.first.data, list.first.names, list.first.np);
        current1.next = list.first.next;
        list.delete(current1);
        list.print();

        System.out.println("删除尾结点");
        Node current2 = new Node(list.first.data, list.first.names, list.first.np);
        current2.next = list.first.next;
        list.delete(current2);
        list.print();

        System.out.println("删除data为4的节点节点");
        Node current3 = new Node(list.first.data, list.first.names, list.first.np);
        current3.next = list.first.next;
        while (current3.data != 4) {
            current3 = current3.next;
        }
        list.delete(current3);
        list.print();

        System.out.println("翻转链表");
        list.reverse_print();

    }
}
