package CH07._01;

/**
 * Create by xong on 2018/4/12
 * 相邻矩阵来表示无向图形
 */
public class CH07_01_Main {
    public static void main(String[] args) {
        int[][] data = {
                {1, 2}, {2, 1}, {1, 5}, {5, 1}, {2, 3}, {3, 2},
                {2, 4}, {4, 2}, {3, 4}, {4, 3}, {3, 5}, {5, 3},
                {4, 5}, {5, 4}};

        int arr[][] = new int[6][6];
        // 清空矩阵
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = 0;
            }
        }

        int tempI, tempJ;

        // 存入矩阵中
        for (int i = 0; i < data.length; i++) {
            // 起始点
            tempI = data[i][0];
            // 终止点
            tempJ = data[i][1];
            // 有边的点填入1
            arr[tempI][tempJ] = 1;
        }
        System.out.println("无向图形矩阵: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("[" + arr[i][j] + "] ");
            }
            System.out.println();
        }
    }
}
