package CH06._01;

/**
 * Create by xong on 2018/4/10
 * 小于父节点的值放在左子节点
 * 大于父节点的值放在右子节点
 */
public class CH06_01_Main {
    public static void main(String[] args) {
        int level;
        int data[] = {6, 3, 5, 9, 7, 8, 4, 2};
        int btree[] = new int[16];

        for (int i = 0; i < btree.length; i++) {
            btree[i] = 0;
        }
        System.out.println("原数组内容：");
        for (int i = 0; i < data.length; i++) {
            System.out.print("[" + data[i] + "]\t");
        }
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            for (level = 1; btree[level] != 0;) {
                if (data[i] > btree[level]) {
                    level = level * 2 + 1;
                } else {
                    level = level * 2;
                }
            }
            btree[level] = data[i];
        }

        System.out.println("二叉树内容:");
        for (int i = 1; i < btree.length; i++) {
            System.out.print("[" + btree[i] + "]\t");
        }
    }
}
