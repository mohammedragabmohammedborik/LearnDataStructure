package CH09;

/**
 * Create by xong on 2018/4/18
 */
public class CH09_03_Main {
    public static void main(String[] args) {
        int data[] = new int[80];
        for (int i = 0; i < 80; i++) {
            data[i] = (((int) (Math.random() * 150)) % 150 + 1);
        }
        // 排序
        quick(data, 0, data.length - 1);
        showData(data);
        int val = 10;
        int num = interpolation(data, 0, data.length - 1, val);
        if (num == -1) {
            System.out.print("##### 没有找到[" + val + "] #####\n");
        } else {
            System.out.print("在第" + (num + 1) + "个位置找到 [" + data[num] + "]\n");
        }

    }

    // 插值查找
    private static int interpolation(int[] data, int low, int high, int val) {
        while (low < high) {
            int temp = (val - data[low]) * (high - low) / (data[high] - data[low]);
            int mid = low + temp;
            if (mid > data.length) {
                return -1;
            }
            if (val < data[low] || val > data[high]) {
                return -1;
            }
            if (val == data[mid]) {
                return mid;
            } else if (val < data[mid]) {
                high = mid - 1;
            } else if (val > data[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static void showData(int[] data) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(i * 8 + j + 1 + " [" + data[i * 8 + j] + "] ");
            }
            System.out.println();
        }
    }


    private static void quick(int[] data, int left, int right) {
        int l_idx;
        int r_idx;
        if (left >= right) {
            return;
        }
        l_idx = left + 1;
        r_idx = right;
        for (; ; ) {
            // 从左到右
            for (int i = left + 1; i < right; i++) {
                if (data[i] > data[left]) {
                    l_idx = i;
                    break;
                }
                l_idx++;
            }
            // 从右到左
            for (int j = right; j > left; j--) {
                if (data[j] < data[left]) {
                    r_idx = j;
                    break;
                }
                r_idx--;
            }
            // 判断是否符合条件
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
            quick(data, left, r_idx - 1);
            quick(data, r_idx + 1, right);
        }
    }
}
