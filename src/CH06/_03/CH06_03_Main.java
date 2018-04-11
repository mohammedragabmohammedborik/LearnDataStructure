package CH06._03;

/**
 * Create by xong on 2018/4/11
 */
public class CH06_03_Main {
    public static void main(String[] args) {
        int arr[] = {7, 4, 1, 5, 13, 8, 11, 12, 15, 9, 2};
        System.out.println("原始数组内容:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] + "]  ");
        }
        System.out.println();
        BinarySearch tree = new BinarySearch();
        for (int i = 0; i < arr.length; i++) {
            tree.addTreeNode(arr[i]);
        }

        if (tree.findTree(tree.rootNode, 8)) {
            System.out.print("需要寻找的值[8]\t");
        }
    }
}
