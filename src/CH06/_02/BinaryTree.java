package CH06._02;

/**
 * Create by xong on 2018/4/10
 * 以链表实现二叉树
 * 小于父节点的在左树
 * 大于父节点的在右树
 * 二叉树的遍历：
 * 中序遍历：左子树 -> 根节点 -> 右子树
 * 前序遍历：根节点 -> 左子树 -> 右子树
 * 后序遍历：左子树 -> 右子树 -> 根节点
 *
 * 由于在将数据放入二叉树时是根据：小于父节点的在左树，大于父节点的在右树
 * 当使用中序遍历输出二叉树时，遍历规则是:左子树 -> 根节点 -> 右子树
 * 即左子树 < 根节点 < 右子树
 * 所以使用中序遍历输出二叉树，就是对二叉树进行排序了
 */
class TreeNode {
    int value;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }
}
public class BinaryTree {
    public TreeNode rootNode;// 二叉树根节点

    public BinaryTree(int[] array) {
        for (int i = 0; i < array.length; i++) {
            addNode(array[i]);
        }
    }

    // 将节点添加到二叉树中
    public void addNode(int value) {

        TreeNode currentNode = rootNode;
        TreeNode node = new TreeNode(value);
        if (rootNode == null) { // 建立根节点
            rootNode = node;
            return;
        }
        // 建立二叉树
        while (true) {
            if (value < currentNode.value) { // 小于在左树
                if (currentNode.leftNode == null) {
                    currentNode.leftNode = node;
                    return;
                } else {
                    currentNode = currentNode.leftNode;
                }
            } else { // 大于在右树
                if (currentNode.rightNode == null) {
                    currentNode.rightNode = node;
                    return;
                } else {
                    currentNode = currentNode.rightNode;
                }
            }
        }
    }

    // 中序遍历
    // 中序遍历：左子树 -> 根节点 -> 右子树
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.leftNode);
            System.out.print("[" + node.value + "]\t");
            inOrder(node.rightNode);
        }
    }

    // 前序遍历
    // 前序遍历：根节点 -> 左子树 -> 右子树
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print("[" + node.value + "]\t");
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }

    // 后序遍历
    // 后序遍历：左子树 -> 右子树 -> 根节点
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.print("[" + node.value + "]\t");
        }
    }
}
