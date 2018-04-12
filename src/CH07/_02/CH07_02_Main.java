package CH07._02;

/**
 * Create by xong on 2018/4/12
 * 相邻矩阵来表示有向图形
 * 横坐标为出发点，纵坐标为终点
 */
public class CH07_02_Main {
    public static void main(String[] args) {
        int arr[][] = new int[5][5];
        // 图形各边的起点值及终点值
        int[][] data = {{1, 2}, {2, 1}, {2, 3}, {2, 4}, {4, 3}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = 0;
            }
        }

        int tempI, tempJ;
        for (int i = 0; i < data.length; i++) {
            tempI = data[i][0];
            tempJ = data[i][1];

            arr[tempI][tempJ] = 1;
        }

        System.out.println("有向图形矩阵:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("[" + arr[i][j] + "] ");
            }
            System.out.println();
        }
    }
}
