package CH06._03;

/**
 * Create by xong on 2018/4/11
 * 二叉搜索树
 * 建树规则：
 * 小于根节点的，左边
 * 大于根节点的，右边
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

public class BinarySearch {
    public TreeNode rootNode;
    public static int count = 0;
    // 建树
    public void addTreeNode(int value) {
        TreeNode currentNode = rootNode;
        TreeNode node = new TreeNode(value);
        if (rootNode == null) {
            rootNode = node;
            return;
        }
        while (true) {
            if (value < currentNode.value) {
                if (currentNode.leftNode == null) {
                    currentNode.leftNode = node;
                    return;
                } else {
                    currentNode = currentNode.leftNode;
                }
            } else {
                if (currentNode.rightNode == null) {
                    currentNode.rightNode = node;
                    return;
                } else {
                    currentNode = currentNode.rightNode;
                }
            }
        }
    }

    // 搜索
    public boolean findTree(TreeNode node, int value) {
        if (node == null) {
            return false;
        } else if (node.value == value) {
            System.out.println("共搜索" + count + "次");
            return true;
        } else if (value < node.value) {
            // 若目标值小于当前节点的值，则搜索左树
            count += 1;
            return findTree(node.leftNode, value);
        } else {
            // 反之，即，目标值大于当前节点的值，则搜索右树
            count += 1;
            return findTree(node.rightNode, value);
        }
    }
}
