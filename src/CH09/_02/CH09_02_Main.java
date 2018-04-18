package CH09._02;

/**
 * Create by xong on 2018/4/18
 */
public class CH09_02_Main {
    public static void main(String[] args) {
        int data[] = new int[80];
        for (int i = 0; i < 80; i++) {
            data[i] = (((int) (Math.random() * 150)) % 150 + 1);
        }
        // 对数据进行排序
        quick(data, 0, data.length - 1);
        showData(data);
        int val = 10;
        int num = binSearch(data, 0, data.length - 1, val);
        if (num == -1) {
            System.out.print("##### 没有找到[" + val + "] #####\n");
        } else {
            System.out.print("在第" + (num + 1) + "个位置找到 [" + data[num] + "]\n");
        }
    }

    private static void showData(int[] data) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(i * 8 + j + 1 + " [" + data[i * 8 + j] + "] ");
            }
            System.out.println();
        }
    }

    private static int binSearch(int[] data, int low, int high, int val) {
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (val < data[mid]) {
                high = mid - 1;
            } else if (val > data[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 快速排序
    private static void quick(int[] data, int left, int right) {
        int l_idx;
        int r_idx;
        if (left >= right) {
            return;
        }
        l_idx = left + 1;
        r_idx = right;
        for (; ; ) {
            // 从左向右
            for (int i = left + 1; i < right; i++) {
                if (data[i] > data[left]) {
                    l_idx = i;
                    break;
                }
                l_idx++;
            }
            // 从右向左
            for (int j = right; j > left; j--) {
                if (data[j] < data[left]) {
                    r_idx = j;
                    break;
                }
                r_idx--;
            }
            // 符合条件，交换位置
            if (l_idx < r_idx) {
                int temp = data[l_idx];
                data[l_idx] = data[r_idx];
                data[r_idx] = temp;
            } else {
                break;
            }
        }
        if (l_idx >= r_idx) {
            int temp = data[left];
            data[left] = data[r_idx];
            data[r_idx] = temp;
            // 左边排序
            quick(data, left, r_idx - 1);
            quick(data, r_idx + 1, right);
        }
    }
}
