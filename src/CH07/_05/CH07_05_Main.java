package CH07._05;

/**
 * Create by LiLinXiong on 2018/4/12
 */
public class CH07_05_Main {
    public static int run[] = new int[9];// 用来记录各顶点是否遍历过
    public static GraphLink[] head = new GraphLink[9];
    public final static int MAXSIZE = 10; // 定义队列的最大容量
    static int[] queue = new int[MAXSIZE];// 队列数组的声明
    static int front = -1; // 指向队列的前端
    static int rear = -1;// 指向队列的后端

    // 存入队列
    public static void enqueue(int value) {
        if (rear >= MAXSIZE) {
            return;
        }
        rear++;
        queue[rear] = value;
    }

    // 从队列中取出
    public static int dequeue() {
        if (front == rear) {
            return -1;
        }
        front++;
        return queue[front];
    }

    // 广度优先搜索法
    public static void bfs(int current) {
        Node tempNode;
        // 将节点放入队列
        enqueue(current);
        // 将遍历过的顶点设为1
        run[current] = 1;
        // 打印
        System.out.print("[" + current + "] ");
        // 判断是否为空队列
        while (front != rear) {
            // 取出
            current = dequeue();
            tempNode = head[current].first;
            // 遍历节点
            while (tempNode != null) {
                if (run[tempNode.value] == 0) {
                    enqueue(tempNode.value);
                    run[tempNode.value] = 1;
                    System.out.print("[" + tempNode.value + "] ");
                }
                tempNode = tempNode.next;
            }
        }
    }
    public static void main(String[] args) {
        int[][] data = {{1, 2}, {2, 1}, {1, 3}, {3, 1}, {2, 4}, {4, 2}, {2, 5}, {5, 2},
                {3, 6}, {6, 3}, {3, 7}, {7, 3}, {4, 5}, {5, 4}, {6, 7}, {7, 6}, {5, 8},
                {8, 5}, {6, 8}, {8, 6}};
        for (int i = 1; i < 9; i++) {
            run[i] = 0;
            head[i] = new GraphLink();
            System.out.print("顶点:" + i + "=>");
            for (int j = 0; j < 20; j++) {
                if (data[j][0] == i) {
                    int num = data[j][1];
                    head[i].insert(num);
                }
            }
            head[i].print();
        }
        bfs(1);
        System.out.println();
    }
}
