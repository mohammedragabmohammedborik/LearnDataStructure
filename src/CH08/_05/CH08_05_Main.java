package CH08._05;

/**
 * Create by xong on 2018/4/16
 */
public class CH08_05_Main {
    static int process = 0;
    public static void main(String[] args) {
        int[] data = {6, 5, 9, 7, 2, 8};
        System.out.println("原始数据为:");
        showData(data);
        quick(data, data.length, 0, data.length - 1);
        System.out.println("排序结果:");
        showData(data);
    }

    private static void quick(int[] data, int length, int left, int right) {
        int left_idx;
        int right_idx;
        if (left < right) {
            left_idx = left + 1;
            right_idx = right;
            while (true) {
                System.out.print("[处理过程" + (process++) + "]=> ");
                for (int i = 0; i < length; i++) {
                    System.out.print("[" + data[i] + "] ");
                }
                System.out.println();
                for (int i = left + 1; i <= right; i++)  //2:由左向右找出一个键值大于data[left]者
                {
                    if (data[i] >= data[left]) {
                        left_idx = i;
                        break;
                    }
                    left_idx++;
                }
                for (int j = right; j >= left + 1; j--)   //3:由右向左找出一个键值小于data[left]者
                {
                    if (data[j] <= data[left]) {
                        right_idx = j;
                        break;
                    }
                    right_idx--;
                }
                if (left_idx < right_idx)        //4-1:若left_idx < right_idx
                {
                    int tmp = data[left_idx];
                    data[left_idx] = data[right_idx]; //则 data[left_idx] 和 data[right_idx] 互换
                    data[right_idx] = tmp;       //然后继续排序
                } else {
                    break;               //否则跳出排序过程
                }
            }
            //整理
            if (left_idx >= right_idx)              //5-1:若 left_idx 大于等于 right_idx
            {                               //则将 data[left_idx] 和 data[right_idx] 互换
                int tmp = data[left];
                data[left] = data[right_idx];
                data[right_idx] = tmp;
                //5-2:并以 right_idx 为基准点分成左右两半
                quick(data, length, left, right_idx - 1); //以递归方式分别为左右两半进行排序
                quick(data, length, right_idx + 1, right); //直至完成排序
            }
        }
    }

    private static void showData(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print("[" + data[i] + "] ");
        }
        System.out.println();
    }

}
