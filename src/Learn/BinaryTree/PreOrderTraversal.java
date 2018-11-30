package Learn.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历二叉树  根节点-->左子树-->右子树
 *
 * @author zhongtao on 2018/8/16
 */
public class PreOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(root.val);
            list.addAll(preorderTraversal1(root.left));
            list.addAll(preorderTraversal1(root.right));
        }
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public void preOrder(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            list.add(treeNode.val);
            preOrder(treeNode.left, list);
            preOrder(treeNode.right, list);
        }
    }


    /**
     * 使用stack LIFO
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current == null)
                continue;
            ans.add(current.val);
            stack.push(current.right);
            stack.push(current.left);
        }
        return ans;
    }
}
