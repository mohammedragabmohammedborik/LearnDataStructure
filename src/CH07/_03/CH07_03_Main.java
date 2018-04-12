package CH07._03;

/**
 * Create by xong on 2018/4/12
 */
public class CH07_03_Main {
    public static void main(String[] args) {
        int data[][] = {{1, 2}, {2, 1}, {1, 5}, {5, 1},
                {2, 3}, {3, 2}, {2, 4}, {4, 2}, {3, 4},
                {4, 3}, {3, 5}, {5, 3}, {4, 5}, {5, 4}};

        GraphLink head[] = new GraphLink[6];
        for (int i = 0; i < head.length; i++) {
            head[i] = new GraphLink();
            System.out.print("顶点" + i + "=>");
            for (int j = 0; j < data.length; j++) {
                if (data[j][0] == i) {
                    int node = data[j][1];
                    head[i].insert(node);
                }
            }
            head[i].print();
        }
    }
}
