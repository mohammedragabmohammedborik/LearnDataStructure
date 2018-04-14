package CH07._06;

/**
 * Create by xong on 2018/4/14
 */
public class Node {
    int MaxLength = 20;
    int[] from = new int[MaxLength];
    int[] to = new int[MaxLength];
    int[] find = new int[MaxLength];
    int[] val = new int[MaxLength];
    int[] next = new int[MaxLength];

    public Node() {
        // 初始化，-2表示未用节点
        for (int i = 0; i < MaxLength; i++) {
            next[i] = -2;
        }
    }

    // 搜索可用节点
    public int findFree() {
        int i = 0;
        for (i = 0; i < MaxLength; i++) {
            if (next[i] == -2) {
                break;
            }
        }
        return i;
    }
    // 建立链表
    public void create(int header, int freeNode, int dataNum, int fromNum, int toNum, int findNum) {
        // 当前节点位置
        int pointer;
        if (header == freeNode) {
            val[header] = dataNum;
            from[header] = fromNum;
            find[header] = findNum;
            to[header] = toNum;
            // -1表示k空节点
            next[header] = -1;
        } else {
            pointer = header;
            val[freeNode] = dataNum;
            from[freeNode] = fromNum;
            find[freeNode] = findNum;
            to[freeNode] = toNum;
            next[freeNode] = -1;
            // 找链表尾端
            while (next[pointer] != -1) {
                pointer = next[pointer];
            }
            next[pointer] = freeNode;
        }
    }

    // 打印
    public void printList(int header) {
        int pointer;
        pointer = header;
        while (pointer != -1) {
            System.out.print("起始顶点[" + from[pointer] + "] ");
            System.out.print("终止顶点[" + to[pointer] + "] ");
            System.out.print("路径长度[" + val[pointer] + "] ");
            System.out.println();
            pointer = next[pointer];
        }
    }
}
