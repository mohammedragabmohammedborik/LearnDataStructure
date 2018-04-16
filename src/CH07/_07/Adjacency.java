package CH07._07;

/**
 * Create by xong on 2018/4/16
 */
public class Adjacency {
    final int INFINITE = 99999;
    public int[][] graphMatrix;

    public Adjacency(int[][] weightPath, int number) {
        int startPoint, endPoint;
        graphMatrix = new int[number][number];
        for (int i = 1; i < number; i++) {
            // 初始化
            for (int j = 1; j < number; j++) {
                if (i != j) {
                    graphMatrix[i][j] = INFINITE;
                } else {
                    graphMatrix[i][j] = 0;
                }
            }
            // 填充具体的花费值
            for (int j = 0; j < weightPath.length; j++) {
                // 起点
                startPoint = weightPath[j][0];
                // 终点
                endPoint = weightPath[j][1];
                // 所需的花费
                graphMatrix[startPoint][endPoint] = weightPath[j][2];
            }
        }
    }

    // 显示图形
    public void printGraphMatrix() {
        for (int i = 1; i < graphMatrix.length; i++) {
            for (int j = 1; j < graphMatrix[i].length; j++) {
                if (graphMatrix[i][j] == INFINITE) {
                    System.out.print(" x ");
                } else {
                    if (graphMatrix[i][j] == 0) {
                        System.out.print(" ");
                    }
                    System.out.print(graphMatrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
