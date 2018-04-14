package CH07._06;

/**
 * Create by xong on 2018/4/14
 */
public class CH07_06_Main {
    public static int VERTS = 6;
    public static int[] v = new int[VERTS + 1];
    public static Node NewList = new Node();

    // 寻找最小花费值
    public static int findmincost() {
        int minval = 100;
        int retptr = 0;
        int a = 0;
        while (NewList.next[a] != -1) {
            if (NewList.val[a] < minval && NewList.find[a] == 0) {
                minval = NewList.val[a];
                retptr = a;
            }
            a++;
        }
        NewList.find[retptr] = 1;
        return retptr;
    }

    public static void mintree() {
        int result = 0;
        int mceptr;
        int a = 0;
        for (int i = 0; i <= VERTS; i++) {
            v[i] = 0;
            // 不是空节点
            while (NewList.next[a] != -1) {
                mceptr = findmincost();
                // 避免回路
                v[NewList.from[mceptr]]++;
                v[NewList.to[mceptr]]++;
                if (v[NewList.from[mceptr]] > 1 && v[NewList.to[mceptr]] > 1) {
//                    v[NewList.from[mceptr]]--;
//                    v[NewList.to[mceptr]]--;
                    result = 1;
                } else {
                    result = 0;
                }
                if (result == 0) {
                    System.out.print("起始顶点[" + NewList.from[mceptr] + "] ");
                    System.out.print("终止顶点[" + NewList.to[mceptr] + "] ");
                    System.out.print("路径长度[" + NewList.val[mceptr] + "] ");
                    System.out.println();
                }
                a++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 6}, {1, 6, 12}, {1, 5, 10}, {2, 3, 3}, {2, 4, 5},
                {2, 6, 8}, {3, 4, 7}, {4, 6, 11}, {4, 5, 9}, {5, 6, 16}};
        int dataNum; // 花费
        int fromNum;// 起点
        int toNum; // 终点
        int findNum;
        int header = 0;
        int freeNode;
        System.out.println("建立图形表:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= VERTS; j++) {
                if (data[i][0] == j) {
                    fromNum = data[i][0];
                    toNum = data[i][1];
                    dataNum = data[i][2];
                    findNum = 0;
                    freeNode = NewList.findFree();
                    NewList.create(header, freeNode, dataNum, fromNum, toNum, findNum);
                }
            }
        }
        NewList.printList(header);
        System.out.println("建立最小成本生成树");
        mintree();
    }
}
