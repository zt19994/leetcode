package Learn.BinaryTree;

/**
 * 连接二叉树相邻的节点
 *
 * @author zhongtao on 2018/12/1
 */
public class ConnectTreeNode {

    class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    /**
     * 循环
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode cur = levelStart;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
    }


    /**
     * 迭代
     *
     * @param root
     */
    public void connect1(TreeLinkNode root) {
        if (root == null) return;
        connect(root.left, root.right);
        connect(root.right, root.next);
    }

    private void connect(TreeLinkNode node, TreeLinkNode next) {
        if (node == null) return;
        node.next = next;
        connect(node.left, node.right);
        connect(node.right, next != null ? next.left : null);
    }
}
