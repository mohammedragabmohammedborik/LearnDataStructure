package CH07._08;

/**
 * Create by xong on 2018/4/16
 *
 * https://www.cnblogs.com/ECJTUACM-873284962/p/6995648.html
 */
public class Floyd extends Adjacency {
    private int[][] cost;

    public Floyd(int[][] weightPath, int number) {
        super(weightPath, number);
        cost = new int[number][number];
    }

    public void shortestPath() {
        for (int i = 1; i < graphMatrix.length; i++) {
            for (int j = i; j < graphMatrix[i].length; j++) {
                cost[i][j] = cost[j][i] = graphMatrix[i][j];
            }
        }
        // 经过i个顶点，当i为1时，则为，只允许经过1号点的情况下，任意两点之间的最小花费值
        // 2时，则是在1的基础上，再经过2点，以此类推
        for (int i = 1; i < graphMatrix.length; i++) {
            for (int j = 1; j < graphMatrix.length; j++) {
                for (int k = 1; k < graphMatrix.length; k++) {
                    /*
                     *当允许经过1时，则:
                     * cost[j][k] > cost[j][1] + cost[1][k]
                     * 解释为: j -> 1 花费值 + 1 -> k 花费值
                     */
                    if (cost[j][k] > cost[j][i] + cost[i][k]) {
                        cost[j][k] = cost[j][i] + cost[i][k];
                    }
                }
            }
        }
        System.out.print("顶点 vex1 vex2 vex3 vex4 \n");
        for (int i = 1; i < graphMatrix.length; i++) {
            System.out.print("vex" + i + " ");
            for (int j = 1; j < graphMatrix[i].length; j++) {
                // 调整显示的位置, 显示距离数组
                if (cost[i][j] < 10) {
                    System.out.print(" ");
                }
                if (cost[i][j] < 100) {
                    System.out.print(" ");
                }
                System.out.print(" " + cost[i][j] + " ");
            }
            System.out.println();
        }
    }
}
