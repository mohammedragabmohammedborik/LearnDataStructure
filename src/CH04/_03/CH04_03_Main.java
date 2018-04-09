package CH04._03;

/**
 * Create by xong on 2018/4/9
 * 以链表模拟堆栈
 */
public class CH04_03_Main {
    public static void main(String[] args) {
        StackByLink link = new StackByLink();
        for (int i = 0; i < 10; i++) {
            link.insert(i);
        }
        System.out.println("原始=============");
        link.outputOfStack();
        link.pop();
        System.out.println("出栈==============");
        link.outputOfStack();
    }
}
