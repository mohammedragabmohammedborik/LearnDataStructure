package CH07._07;

/**
 * Create by xong on 2018/4/16
 * 迪杰斯特拉算法类
 */
public class Dijkstra extends Adjacency {
    private int[] cost;
    private int[] selected;

    public Dijkstra(int[][] weightPath, int number) {
        super(weightPath, number);

        cost = new int[number];
        selected = new int[number];
        for (int i = 1; i < number; i++) {
            selected[i] = 0;
        }
    }

    // 单点对全部顶点最短距离
    public void shortestPath(int source) {
        int shortestDistance;
        int shortestVertext = 1;
        for (int i = 1; i < graphMatrix.length; i++) {
            // 即，source到各个顶点的花费值
            // 1 -> 1
            // 1 -> 2
            cost[i] = graphMatrix[source][i];
        }
        selected[source] = 1;
        cost[source] = 0;
        for (int i = 1; i < graphMatrix.length - 1; i++) {
            // 每次遍历，默认最大
            shortestDistance = INFINITE;
            // 当前节点最小花费
            for (int j = 1; j < graphMatrix.length; j++) {
                if (shortestDistance > cost[j] && selected[j] == 0) {
                    shortestVertext = j;
                    shortestDistance = cost[j];
                }
                // 标记
                selected[shortestVertext] = 1;
            }
            // 判断当前节点到各个节点的最小花费
            for (int j = 1; j < graphMatrix.length; j++) {
                if (selected[j] == 0 && cost[shortestVertext] + graphMatrix[shortestVertext][j] < cost[j]) {
                    cost[j] = cost[shortestVertext] + graphMatrix[shortestVertext][j];
                }
            }
        }
        System.out.println("================================");
        System.out.println("顶点" + source + "到各顶点最短距离的最终结果");
        System.out.println("================================");
        for (int i = 1; i < graphMatrix.length; i++) {
            System.out.println("顶点" + source + "到顶点" + i + "的最短距离 = " + cost[i]);
        }
    }
}
