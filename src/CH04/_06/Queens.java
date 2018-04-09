package CH04._06;

/**
 * Create by xong on 2018/4/9
 * 八皇后
 */
public class Queens {
    private int[] queen = null;
    private int number = 0;
    private int size = 0;

    public Queens(int size) {
        number = 0;
        queen = new int[size];
        this.size = size;
        this.decidePosition(0);
    }

    // 核心
    public void decidePosition(int value) {
        int i = 0;
        while (i < size) {
            if (!attack(i, value)) {
                queen[value] = i;
                if (value == 7) {
                    // 打印
                    printTable();
                } else {
                    decidePosition(value + 1);
                }
            }
            i++;
        }
    }

    // 测试在(row, col)上的皇后是否遭受攻击
    // 遭受攻击，返回true，否则返回false
    public boolean attack(int row, int col) {
        int i = 0;
        boolean atk = false;
        int offsetRow = 0;
        int offsetCol = 0;
        while (!atk && i < col) {
            offsetCol = Math.abs(i - col);
            offsetRow = Math.abs(queen[i] - row);
            if ((queen[i] == row) || (offsetRow == offsetCol)) {
                atk = true;
            }
            i++;
        }
        return atk;
    }

    public void printTable() {
        int x = 0, y = 0;
        number += 1;
        System.out.print("\n");
        System.out.print("八皇后问题的第" + number + "组解\n\t");
        for (x = 0; x < size; x++) {
            for (y = 0; y < size; y++) {
                if (x == queen[y]) {
                    System.out.print("<*>");
                } else {
                    System.out.print("<->");
                }
            }
            System.out.print("\n\t");
        }
    }

    public int getNumber() {
        return number;
    }
}
