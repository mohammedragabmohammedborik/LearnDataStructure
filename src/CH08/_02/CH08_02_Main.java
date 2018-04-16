package CH08._02;

/**
 * Create by xong on 2018/4/16
 */
public class CH08_02_Main {
    public static void main(String[] args) {
        int[] data = {6, 5, 9, 7, 2, 8};
        System.out.println("原始数据为:");
        showData(data);
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
            System.out.print("第" + (i + 1) + "次排序后的结果是:");
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
