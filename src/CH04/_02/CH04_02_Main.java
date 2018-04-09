package CH04._02;

import java.io.IOException;

/**
 * Create by xong on 2018/4/9
 * 使用堆栈，模拟洗牌和发牌的过程
 * 0-12 梅花 M
 * 13-25 方块 F
 * 26-38 红桃 H
 * 39-51 黑桃 B
 */
public class CH04_02_Main {
    static int top = -1;

    public static void main(String[] args) throws IOException {
        int card[] = new int[52];
        int stack[] = new int[52];
//        char ascVal = 'M';
        char[] styles = {'M', 'F', 'H', 'B'};
        int style ;
        for (int i = 0; i < 52; i++) {
            card[i] = i;
        }
        int temp;
        // 洗牌
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 51; j++) {
                for (int k = 0; k < 52; k++) {
                    if ((int)(Math.random() * 5) == 2) {
                        temp = card[i];
                        card[i] = card[j];
                        card[j] = temp;
                    }
                }
            }
        }
        int i = 0;
        while (i != 52) {
            // 将52张牌，压入堆栈
            push(stack, 52, card[i]);
            i++;
        }
        System.out.println("A\t B\t C\t D\t");
        System.out.println("===========================");
        while (top >= 0) {
            int item = pop(stack);
            System.out.print("[" + styles[item / 13] + (item % 13 + 1) + "]");
            System.out.print("\t");
            if (top % 4 == 0) {
                System.out.println();
            }
            top--;
        }
    }

    // 将数据压入堆栈
    public static void push(int stack[], int MAX, int val) {
        if (top >= MAX - 1) {
            System.out.println("堆栈已满");
        } else {
            stack[++top] = val;
        }
    }

    // 数据出栈
    public static int pop(int stack[]) {
        if (top < 0) {
            System.out.println("堆栈已空");
            return -1;
        } else {
            return stack[top];
        }
    }
}
