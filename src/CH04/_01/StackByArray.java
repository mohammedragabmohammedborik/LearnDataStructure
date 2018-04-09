package CH04._01;

/**
 * Create by xong on 2018/4/9
 * 数组模拟堆栈
 */
public class StackByArray {
    private int[] stack;
    private int top;

    public StackByArray(int stack_size) {
        stack = new int[stack_size];
        top = -1;
    }

    // 压入堆栈
    public boolean push(int data) {
        if (top >= stack.length) {
            System.out.println("堆栈已满，无法再加入");
            return false;
        } else {
            stack[++top] = data;
            return true;
        }
    }

    public boolean empty() {
        return top == -1;
    }

    public int pop() {
        return empty() ? -1 : stack[top--];
    }
}
