package CH07._04;

/**
 * Create by xong on 2018/4/12
 * 从图形的某一顶点开始遍历，被访问过的顶点就做上已访问的记号，接着遍历此顶点的所有相邻且未访问过的顶点中的任意一个顶点，
 * 并做上已访问的记号，再以该点为新的起点继续进行先深后广的搜索.
 */
public class CH07_04_Main {
    public static int[] run = new int[9];
    public static GraphLink[] head = new GraphLink[9];

    public static void dfs(int current) {
        run[current] = 1;
        System.out.print("[" + current + "]");
        // 头结点
        while (head[current].first != null) {
            // 若顶点尚未遍历，就进行dfs的递归调用
            current = head[current].first.value;
            if (run[current] == 0) {
                dfs(current);
            }
            head[current].first = head[current].first.next;
        }
    }

    public static void main(String[] args) {
        int[][] data = {
                {1, 2}, {2, 1}, {1, 3}, {3, 1},
                {2, 4}, {4, 2}, {2, 5}, {5, 2},
                {3, 6}, {6, 3}, {3, 7}, {7, 3},
                {4, 5}, {5, 4}, {6, 7}, {7, 6},
                {5, 8}, {8, 5}, {6, 8}, {8, 6}};
        System.out.println("图形的邻接表内容：");
        for (int i = 1; i < 9; i++) {
            run[i] = 0;
            head[i] = new GraphLink();
            System.out.print("顶点" + i + "=>");
            for (int j = 0; j < 20; j++) {
                if (data[j][0] == i) {
                    int num = data[j][1];
                    head[i].insert(num);
                }
            }
            head[i].print();
        }
        System.out.println("深度优先遍历顶点:");
        dfs(1);
        System.out.println();
    }
}
