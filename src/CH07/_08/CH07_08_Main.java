package CH07._08;

/**
 * Create by xong on 2018/4/16
 */
public class CH07_08_Main {
    public static void main(String[] args) {
        int weightPath[][] =
                {
//                {1, 2, 10},{2, 3, 20},
//                {2, 4, 25},{3, 5, 18},
//                {4, 5, 22},{4, 6, 95},{5, 6, 77}
                {1, 2, 2}, {1, 3, 6}, {1, 4, 4},
                {2, 3, 3},
                {3, 1, 7}, {3, 4, 1},
                {4, 1, 5}, {4, 3, 12}
                };
        Floyd object = new Floyd(weightPath, 5);
        System.out.println("==========================");
        object.printGraphMatrix();
        System.out.println("==================================");
        System.out.println("所有顶点两两之间的最短距离: ");
        System.out.println("==================================");
        object.shortestPath();
    }
}
