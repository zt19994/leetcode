package Learn.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层级遍历 广度优先搜索
 *
 * @author zhongtao on 2018/8/17
 */
public class LevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 层级遍历 广度优先搜索
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int queueL = 0;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            queueL = queue.size();  //每层节点数
            for (int i = 0; i < queueL; i++) {
                TreeNode current = queue.poll();
                list.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
