package CH08._03;

/**
 * Create by xong on 2018/4/16
 */
public class CH08_03_Main {
    public static void main(String[] args) {
        int[] data = {6, 5, 9, 7, 2, 8};
        System.out.println("原始数据:");
        showData(data);
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j = i - 1;
            while (j >= 0 && temp < data[j]) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;
            System.out.print("第" + i + "次排序后的结果是:");
            showData(data);
        }
    }

    private static void showData(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print("[" + data[i] + "] ");
        }
        System.out.println();
    }
}
