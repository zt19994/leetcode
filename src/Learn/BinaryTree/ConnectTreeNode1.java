package Learn.BinaryTree;

/**
 * 连接二叉树相邻的节点
 *
 * @author zhongtao on 2018/12/3l
 */
public class ConnectTreeNode1 {

    class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        for (TreeLinkNode head = root; head != null; ) {
            TreeLinkNode nextHead = new TreeLinkNode(0);
            TreeLinkNode nextTail = nextHead;
            for (TreeLinkNode node = head; node != null; node = node.next) {
                if (node.left != null) {
                    nextTail.next = node.left;
                    nextTail = node.left;
                }
                if (node.right != null) {
                    nextTail.next = node.right;
                    nextTail = node.right;
                }
            }
            head = nextHead.next;
        }
    }

    //和上面的算法差不多 思路是一样的
    public void connect3(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;
            while (root != null) {
                if (root.left != null) {
                    currentChild.next = root.left;
                    currentChild = currentChild.next;
                }
                if (root.right != null) {
                    currentChild.next = root.right;
                    currentChild = currentChild.next;
                }
                root = root.next;   //同层间移动
            }
            root = tempChild.next;  //向下一层移动
        }
    }

    //这个算法中 暂存下一层head的node只创建一次
    public void connect1(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            //相当于去掉了循环
            if (root == null) {
                pre = dummyHead;
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
    }


    //迭代的算法
    public void connect2(TreeLinkNode root) {
        if (root == null) return;

        TreeLinkNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                cur.left.next = (cur.right != null) ? cur.right : getNext(cur);
            }

            if (cur.right != null) {
                cur.right.next = getNext(cur);
            }
            cur = cur.next;
        }

        connect2(root.left);
        connect2(root.right);
    }

    private TreeLinkNode getNext(TreeLinkNode root) {
        TreeLinkNode temp = root.next;

        while (temp != null) {
            if (temp.left != null) return temp.left;
            if (temp.right != null) return temp.right;
            temp = temp.next;
        }
        return null;
    }


}
