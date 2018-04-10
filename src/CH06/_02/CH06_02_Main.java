package CH06._02;

/**
 * Create by xong on 2018/4/10
 * 列表表示法(也就是链表来存储二叉树)
 */
public class CH06_02_Main {
    public static void main(String[] args) {
        int[] array = {7, 4, 1, 5, 16, 8, 11, 12, 15, 9, 2};
        BinaryTree tree = new BinaryTree(array);
        System.out.println("二叉树前序遍历结果:");
        tree.preOrder(tree.rootNode);
        System.out.println("\n二叉树中序遍历结果:");
        tree.inOrder(tree.rootNode);
        System.out.println("\n二叉树后序遍历结果:");
        tree.postOrder(tree.rootNode);
    }
}
