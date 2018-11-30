package Learn.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历二叉树 左子树-->右子树-->根节点
 *
 * @author zhongtao on 2018/8/17
 */
public class PostOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //第一种 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.addAll(postorderTraversal(root.left));
            list.addAll(postorderTraversal(root.right));
            list.add(root.val);
        }
        return list;
    }

    //第二种 递归
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            PostOrder(root, list);
        }
        return list;
    }

    public void PostOrder(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            PostOrder(treeNode.left, list);
            PostOrder(treeNode.right, list);
            list.add(treeNode.val);
        }
    }

    //第三种 迭代 使用链表
    public List<Integer> postorderTraversal3(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.addFirst(current.val);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return list;
    }
}
