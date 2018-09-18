package Learn.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 递归树的最大深度
 *
 * @author zhongtao on 2018/8/17
 */
public class MaxDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * "Bottom-up" Solution
     *
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        int result = 0;
        if (root == null) {
            return 0;
        }
        result = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return result;
    }


    /**
     * "Top-down" Solution
     */
    // don't forget to initialize answer before call maximum_depth
    private int answer;

    private void maximum_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            //更新最大深度
            answer = Math.max(answer, depth);
        }
        maximum_depth(root.left, depth + 1);
        maximum_depth(root.right, depth + 1);
    }


    /**
     * 深度优先来获取最大深度
     *
     * @param root
     * @return
     */
    private int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if (current.left != null) {
                stack.push(current.left);
                value.push(temp + 1);
            }
            if (current.right != null) {
                stack.push(current.right);
                value.push(temp + 1);
            }
        }
        return max;
    }


    /**
     * 广度优先来获取最大深度
     *
     * @param root
     * @return
     */
    private int maxDepthBFS(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            //队列长度大于0
            while (size-- > 0){
                TreeNode current = queue.poll();
                if (current.left!=null){
                    queue.offer(current.left);
                }
                if (current.right!=null){
                    queue.offer(current.right);
                }
            }
            //每多一级深度加1
            count++;
        }
        return count;
    }
}
