package CH05._03;

/**
 * Create by xong on 2018/4/10
 * 输入限制性双向队列
 */
public class CH05_03_Main {
    public static void main(String[] args) {
        QueueListLink queue = new QueueListLink();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i + 1);
        }

        for (int i = 0; i < 10; i++) {
            int temp;
            if (i % 2 == 0) {
                temp = queue.dequeue(2);
                System.out.println("*****从双向队列前端依次取出的值为：" + temp);
            } else {
                temp = queue.dequeue(1);
                System.out.println("=====从双向队列尾端依次取出的值为：" + temp);
            }
        }
    }
}
