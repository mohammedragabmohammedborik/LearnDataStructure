package CH06._04;

/**
 * Create by xong on 2018/4/11
 * 线索二叉树
 */

class ThreadNode {
    int value;
    int leftThread;
    int rightThread;
    ThreadNode leftNode;
    ThreadNode rightNode;

    public ThreadNode(int value) {
        this.value = value;
        this.leftThread = 0;
        this.rightThread = 0;
        this.leftNode = null;
        this.rightNode = null;
    }
}

public class ThreadedBinaryTree {
    public ThreadNode rootNode;

    public ThreadedBinaryTree() {
        rootNode = null;
    }

    public void addNode(int value) {
        ThreadNode newnode = new ThreadNode(value);
        ThreadNode current;
        ThreadNode parent;
        ThreadNode previous = new ThreadNode(value);
        int pos;
        //设定线索二叉树的开头节点
        if (rootNode == null) {
            rootNode = newnode;
            rootNode.leftThread = 0;
            rootNode.rightThread = 1;
            rootNode.rightNode = null;
            rootNode.leftNode = rootNode;
            return;
        }
        //设定开头节点所指的节点
        current = rootNode.rightNode;
        if (current == null) {
            newnode.leftNode = rootNode;
            newnode.rightNode = rootNode;
            rootNode.rightNode = newnode;
            return;
        }
        parent = rootNode; //父节点是开头节点
        pos = 0; //设定二叉树中的行进方向
        while (current != null) {
            if (current.value > value) {
                if (pos != -1) {
                    pos = -1;
                    previous = parent;
                }
                parent = current;
                if (current.leftThread == 1)
                    current = current.leftNode;
                else
                    current = null;
            } else {
                if (pos != 1) {
                    pos = 1;
                    previous = parent;
                }
                parent = current;
                if (current.rightThread == 1)
                    current = current.rightNode;
                else
                    current = null;
            }
        }
        if (parent.value > value) {
            newnode.leftNode = previous;
            newnode.rightNode = parent;
            parent.leftThread = 1;
            parent.leftNode = newnode;
        } else {
            newnode.rightNode = previous;
            newnode.leftNode = parent;
            parent.rightThread = 1;
            parent.rightNode = newnode;
        }
        return;
    }

    public void print() {
        ThreadNode tempNode;
        tempNode = rootNode;
        do {
            if (tempNode.rightThread == 0) {
                tempNode = tempNode.rightNode;
            } else {
                tempNode = tempNode.rightNode;
                while (tempNode.leftThread != 0) {
                    tempNode = tempNode.leftNode;
                }
            }
            if (tempNode != rootNode) {
                System.out.println(
                        "左[" + tempNode.leftThread + "] " +
                        "右[" + tempNode.rightThread + "] " +
                                "值[" + tempNode.value + "] ");

                System.out.println(
                        "左*[" + tempNode.leftNode.leftThread + "] " +
                        "右*[" + tempNode.leftNode.rightThread + "] " +
                                "值*[" + tempNode.leftNode.value + "] ");

                System.out.println(
                        "左#[" + tempNode.leftNode.leftThread + "] " +
                        "右#[" + tempNode.leftNode.rightThread + "] " +
                                "值#[" + tempNode.leftNode.value + "] ");
                System.out.println("=========================");
            }
        } while (tempNode != rootNode);
    }
}
