package CH04._01;

/**
 * Create by xong on 2018/4/9
 */
public class CH04_01_Main {
    public static void main(String[] args) {
        StackByArray array = new StackByArray(10);
        for (int i = 0; i < 10; i++) {
            array.push(i + 1);
        }
        while (!array.empty()) {
            System.out.println("堆栈弹出的顺序为：" + array.pop());
        }
    }
}
