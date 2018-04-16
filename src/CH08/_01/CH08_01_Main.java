package CH08._01;

/**
 * Create by xong on 2018/4/16
 */
public class CH08_01_Main {
    public static void main(String[] args) {
        int[] data = {6, 5, 9, 7, 2, 8};
//        baseShow(data);
        bubbleShow(data);
    }

    private static void bubbleShow(int[] data) {
        System.out.println("原始数据:");
        for (int i = 0; i < data.length; i++) {
            System.out.print("[" + data[i] + "] ");
        }
        System.out.println();
        boolean flag;
        for (int i = data.length - 1; i >= 0; i--) {
            flag = true;
            for (int j = 0; j < i; j++) {
                if (data[j + 1] < data[j]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            System.out.print("第" + (data.length - i) + "次排序后的结果是:");
            for (int j = 0; j < data.length; j++) {
                System.out.print("[" + data[j] + "] ");
            }
            System.out.println();
        }
        System.out.println("排序后:");
        for (int i = 0; i < data.length; i++) {
            System.out.print("[" + data[i] + "] ");
        }

    }

    private static void baseShow(int[] data) {
        System.out.println("原始数据:");
        for (int i = 0; i < data.length; i++) {
            System.out.print("[" + data[i] + "] ");
        }
        System.out.println();
        for (int i = data.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
            System.out.print("第" + (data.length - i) + "次排序后的结果是:");
            for (int j = 0; j < data.length; j++) {
                System.out.print("[" + data[j] + "] ");
            }
            System.out.println();
        }
        System.out.println("排序后:");
        for (int i = 0; i < data.length; i++) {
            System.out.print("[" + data[i] + "] ");
        }
    }
}
