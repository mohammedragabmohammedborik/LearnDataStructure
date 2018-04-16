package CH07._07;

/**
 * Create by xong on 2018/4/16
 */
public class CH07_07_Main {
    public static void main(String[] args) {
        int[][] weightPath = {{1, 2, 10}, {2, 3, 20}, {2, 4, 25},
                {3, 5, 18}, {4, 5, 22}, {4, 6, 95}, {5, 6, 77}};
        Dijkstra object = new Dijkstra(weightPath, weightPath.length);
        System.out.println("================================");
        object.printGraphMatrix();
        object.shortestPath(1);
    }
}
