package CH06._04;

/**
 * Create by xong on 2018/4/11
 */
public class CH06_04_Main {
    public static void main(String[] args) {
        int[] data1 = {0, 10, 20, 30, 100, 399, 453, 43, 237, 373, 655};
        ThreadedBinaryTree tree = new ThreadedBinaryTree();

//        for (int i = 0; i < data1.length; i++) {
//            tree.addNode(data1[i]);
//        }

//        tree.print();
        System.out.println("=====================");
        int[] data2 = {0, 7, 4, 13/*, 1, 5, 8, 15*/};
        ThreadedBinaryTree tree2 = new ThreadedBinaryTree();

        for (int i = 0; i < data2.length; i++) {
            tree2.addNode(data2[i]);
        }
        System.out.println(
                "左[" + tree2.rootNode.leftThread + "] " +
                        "右[" + tree2.rootNode.rightThread + "] " +
                        "值[" + tree2.rootNode.value + "] ");
        System.out.println("=====================");
        tree2.print();

    }
}
