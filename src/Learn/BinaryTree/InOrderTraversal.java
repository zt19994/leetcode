package Learn.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历二叉树 左子树-->根节点--> 右子树
 *
 * @author zhongtao on 2018/8/17
 */
public class InOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //第一种 递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.addAll(inorderTraversal1(root.left));
            list.add(root.val);
            list.addAll(inorderTraversal1(root.right));
        }
        return list;
    }

    //第二种 递归
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        InOrder(root, list);
        return list;
    }

    public void InOrder(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            InOrder(treeNode.left, list);
            list.add(treeNode.val);
            InOrder(treeNode.right, list);
        }
    }

    //第三种 迭代

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        PushLeftNode(root, stack);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);
            PushLeftNode(current.right, stack);
        }
        return list;
    }

    public void PushLeftNode(TreeNode treeNode, Stack<TreeNode> stack) {
        if (treeNode == null) return;
        while (treeNode != null) {
            stack.push(treeNode);
            treeNode = treeNode.left;
        }
    }
}
