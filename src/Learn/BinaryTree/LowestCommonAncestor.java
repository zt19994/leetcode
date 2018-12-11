package Learn.BinaryTree;

/**
 * Lowest Common Ancestor of a Binary Tree  二叉树的最低公共祖先
 *
 * @author zhongtao on 2018/12/11
 */
public class LowestCommonAncestor {

    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 判断 q 和 p 是否在同一子树
     * 1、在同一子树，哪个在前返回哪个
     * 2、不在同一子树，在同一层，则返回上一层节点
     * 3、不在同一子树，并且不在同一层，返回根节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
