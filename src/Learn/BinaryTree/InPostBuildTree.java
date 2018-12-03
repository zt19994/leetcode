package Learn.BinaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 通过中序遍历和后续遍历的集合，创建树
 *
 * @author zhongtao on 2018/8/18
 */
public class InPostBuildTree {

     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 遍历解决方案
     */
    public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i) {
            hm.put(inorder[i], i);
        }
        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
    }

    /**
     * @param inorder   中序列表
     * @param inStart   中序开始
     * @param inEnd     中序结束
     * @param postorder 后序列表
     * @param postStart 后序开始
     * @param postEnd   后序结束
     * @param hm        中序map
     * @return
     */
    private TreeNode buildTreePostIn(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> hm) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = hm.get(postorder[postEnd]); //获取中序中的根节点索引
        root.left = buildTreePostIn(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + rootIndex - inStart - 1, hm);
        root.right = buildTreePostIn(inorder, rootIndex + 1, inEnd, postorder, postStart + rootIndex - inStart, postEnd - 1, hm);
        return root;
    }


    /**
     * 迭代解决方案
     */
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int ip = inorder.length - 1;  //中序长度
        int pp = postorder.length - 1; //后序长度

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        //后序遍历最后一个是根节点
        TreeNode root = new TreeNode(postorder[pp]);
        stack.push(root);
        pp--;

        while (pp >= 0) {
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                prev = stack.pop();
                ip--;
            }
            TreeNode newNode = new TreeNode(postorder[pp]);
            if (prev != null) {
                prev.left = newNode;
            } else if (!stack.isEmpty()) {
                TreeNode currTop = stack.peek();
                currTop.right = newNode;
            }
            stack.push(newNode);
            prev = null;
            pp--;
        }
        return root;
    }
}
