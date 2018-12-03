package Learn.BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过前序和中序集合，构建二叉树
 *
 * @author zhongtao on 2018/11/30
 */
public class PreInBuildTree {

     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode bulidTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    /**
     * @param preorder 前序列表
     * @param preStart 前序开始
     * @param preEnd   前序结束
     * @param inorder  中序列表
     * @param inStart  中序开始
     * @param inEnd    中序结束
     * @param map      中序map
     * @return
     */
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        Integer rootIndex = map.get(preorder[preStart]);
        root.left = helper(preorder, preStart + 1, preStart + rootIndex - inStart, inorder, inStart, rootIndex - 1, map);
        root.right = helper(preorder, preStart + rootIndex - inStart + 1, preEnd, inorder, rootIndex + 1, inEnd, map);
        return root;
    }


    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }


    private int preIndex = 0;
    private int inIndex = 0;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, null);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, TreeNode end){
        if(inIndex > inorder.length - 1 || (end != null && end.val == inorder[inIndex])){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex++]);
        root.left = dfs(preorder, inorder, root);

        inIndex++;
        root.right = dfs(preorder, inorder, end);

        return root;
    }
}
