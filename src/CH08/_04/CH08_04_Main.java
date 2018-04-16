package CH08._04;

/**
 * Create by xong on 2018/4/16
 */
public class CH08_04_Main {
    public static void main(String[] args) {
        int[] data = {6, 5, 9, 7, 2, 8};
        System.out.println("原始数据为:");
        showData(data);
        int jmp = data.length / 2;
        int k = 1;
        while (jmp != 0) {
            for (int i = jmp; i < data.length; i++) {
                int temp = data[i];
                int j = i - jmp;
                while (j >= 0 && temp < data[j]) {
                    data[j + jmp] = data[j];
                    j = j - jmp;
                }
                data[jmp + j] = temp;
            }
            System.out.print("第" + (k++) + "次排序后的结果是:");
            showData(data);
            jmp = jmp / 2;
        }
    }
    private static void showData(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print("[" + data[i] + "] ");
        }
        System.out.println();
    }

}
