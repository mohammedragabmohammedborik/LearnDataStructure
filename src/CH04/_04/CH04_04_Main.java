package CH04._04;

/**
 * Create by xong on 2018/4/9
 * 利用汉诺塔函数求出不同盘子数的盘子移动步骤
 * 目的：
 * 将N个盘子从A移动到C
 * 首先将第N-1个盘子 -> B; 这样第N个盘子才 -> C
 * 只有将第N-2个盘子 -> C; 这样才能N-1个盘子 -> B
 * ...
 * 推荐链接:https://www.cnblogs.com/tonglin0325/p/5362236.html
 * 图二叉树遍历
 * A,B,C
 * 目的，A->C
 * 对于左子树:
 * A->B
 * 继续向下分则：
 * A->C  C->B
 * ....
 * 对于右子树:
 * B->C
 * 继续向下分:
 * B->A A->C
 * ....
 */
public class CH04_04_Main {
    public static void main(String[] args) {
        hanoi(2, 1, 2, 3);
    }

    public static void hanoi(int n, int from, int inter, int to) {
        if (n == 1) {
            System.out.println("盘子从" + from + "->" + to);
        } else {
            hanoi(n - 1, from, to, inter);
            System.out.println("盘子从" + from + "->" + to);
            hanoi(n - 1, inter, from, to);
        }
    }
}
