package CH04._05;

/**
 * Create by xong on 2018/4/9
 */
public class CH04_05_Main {
    public static int ExitX = 8;            //定义出口的X坐标在第八行
    public static int ExitY = 10;        //定义出口的Y坐标在第十列
    public static int[][] MAZE = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},    //声明迷宫数组
            {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
            {1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    public static void main(String[] args) {
        int i, j, x, y;
        TraceRecord path = new TraceRecord();
        x = 1;
        y = 1;
        System.out.print("[迷宫的路径(0的部分)]\n");
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 12; j++) {
                System.out.print(MAZE[i][j] + "\t");
            }
            System.out.print("\n");
        }
        while (x <= ExitX && y <= ExitY) {
            MAZE[x][y] = 2;
            if (MAZE[x - 1][y] == 0) { // 上
                x -= 1;
                path.insert(x, y);
            } else if (MAZE[x + 1][y] == 0) { // 下
                x += 1;
                path.insert(x, y);
            } else if (MAZE[x][y - 1] == 0) { // 左
                y -= 1;
                path.insert(x, y);
            } else if (MAZE[x][y + 1] == 0) { // 右
                y += 1;
                path.insert(x, y);
            } else if (chkExit(x, y, ExitX, ExitY) == 1)
                break;
            else {
                MAZE[x][y] = 2;
                // 走进死胡同，返回上一个节点
                path.delete();
                x = path.last.x;
                y = path.last.y;
            }
        }
        System.out.print("[老鼠走过的路径(2的部分)]\n");
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 12; j++) {
                System.out.print(MAZE[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    public static int chkExit(int x, int y, int ex, int ey) {
        if (x == ex && y == ey) {
            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 2)
                return 1;
            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 2 || MAZE[x][y + 1] == 1)
                return 1;
            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 2 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 1)
                return 1;
            if (MAZE[x - 1][y] == 2 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 1)
                return 1;
        }
        return 0;
    }
}
