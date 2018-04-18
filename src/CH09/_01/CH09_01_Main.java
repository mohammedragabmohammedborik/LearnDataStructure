package CH09._01;

/**
 * Create by xong on 2018/4/18
 */
public class CH09_01_Main {
    public static void main(String[] args) {
        int data[] = new int[100];
        for (int i = 0; i < 80; i++) {
            data[i] = (((int) (Math.random() * 150)) % 150 + 1);
        }
        int val = 10;
        boolean find = false;
        for (int i = 0; i < 80; i++) {
            if (data[i] == val) {
                System.out.print("在第" + (i + 1) + "个位置找到键值 [" + data[i] + "]\n");
                find = true;
            }
        }
        if (!find) {
            System.out.print("######没有找到[" + val + "]######\n");
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(i * 8 + j + 1 + " [" + data[i * 8 + j] + "] ");
            }
            System.out.println();
        }
    }
}
