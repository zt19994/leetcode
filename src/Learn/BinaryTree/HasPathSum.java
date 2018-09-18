package Learn.BinaryTree;

/**
 * 路径和
 *
 * @author zhongtao on 2018/8/18
 */
public class HasPathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //减法
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && sum - root.val == 0)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    //加法
    public boolean hasPathSum2(TreeNode root, int sum) {
        return pathSum(root, 0, sum);
    }

    public boolean pathSum(TreeNode root, int now, int sum) {
        if (root == null) return false;
        now = now + root.val;
        if (now == sum && root.left == null && root.right == null) return true;
        return pathSum(root.left, now, sum) || pathSum(root.right, now, sum);
    }


}

