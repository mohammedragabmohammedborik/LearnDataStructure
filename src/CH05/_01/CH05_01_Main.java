package CH05._01;

/**
 * Create by xong on 2018/4/10
 * 实现以链表建立队列
 */
public class CH05_01_Main {

    public static void main(String[] args) {
        QueueListLink queue = new QueueListLink();
        System.out.println("==========================");
        for (int i = 0; i < 20; i++) {
            System.out.println("在队列前端加入第" + i + "个数据，此数据值为" + (i + 1));
            queue.enqueue(i + 1);
        }
        System.out.println("==========================");
        while (true) {
            if (!(queue.front == null)) {
                int value = queue.dequeue();
                System.out.println("从队列前端依序取出的元素数据值为：" + value);
            } else {
                break;
            }
        }
    }
}
