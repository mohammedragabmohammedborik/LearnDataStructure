package CH05._02;

/**
 * Create by xong on 2018/4/10
 * 环形队列：内存上是没有环形结构的，因此环形队列事实上是数组的线性空间来实现的。
 * 因此环列队列的是逻辑上将数组元素q[0]与q[MAX-1]连接，形成一个存放队列的环形空间。
 * 链接：https://blog.csdn.net/sherilindas/article/details/51927406
 * 链接：https://blog.csdn.net/jiutianhe/article/details/18606295
 */
public class CH05_02_Main {
    public static void main(String[] args) {
        LoopListLink loop = new LoopListLink(5);
        for (int i = 0; i < 6; i++) {
            Node node = new Node(i + 1);
            loop.add(node);
        }
        System.out.println(loop.toString());
        loop.remove();
        System.out.println("移除一个元素后:");
        System.out.println(loop.toString());
        Node node = new Node(6);
        loop.add(node);
        System.out.println("移除一个元素后，再添加一个新元素:");
        System.out.println(loop.toString());
    }
}
