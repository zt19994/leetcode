package Learn.Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成树 -- 给定一个整数n，生成所有结构上唯一的BST(二叉搜索树)，存储值1…n。
 *
 * @author zt1994 2019/4/20 13:46
 */
public class GenerateTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 生成树
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        return genTrees(1, n);
    }

    public List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();

        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {

            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);

            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }


    /**
     * 测试生成树
     */
    @Test
    public void testGenerateTrees() {
        List<TreeNode> treeNodes = generateTrees(3);
        for (TreeNode treeNode : treeNodes) {
            System.out.println(treeNode.val);
        }
    }
}
