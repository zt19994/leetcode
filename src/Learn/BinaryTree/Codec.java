package Learn.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化和反序列化二叉树
 *
 * @author zhongtao on 2018/12/13
 */
public class Codec {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 序列化 将二叉树转化为字符串
     */
    public String serializa(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                result.append("n ");
                continue;
            }
            result.append(node.val).append(" ");
            q.add(node.left);
            q.add(node.right);
        }
        return result.toString();
    }

    /**
     * 反序列化 将字符串转化为二叉树
     */
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }


    private StringBuilder sb = new StringBuilder();

    public String serialize1(TreeNode root) {
        sc(root);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void sc(TreeNode x) {
        if (x == null) {
            sb.append("#,");
            return;
        }
        sb.append(x.val).append(",");
        sc(x.left);
        sc(x.right);
    }

    private String[] sx;
    private int id;

    public TreeNode deserialize1(String data) {
        if (data.equals("#")) return null;
        sx = data.split(",");
        id = 0;
        return dc();
    }

    private TreeNode dc() {
        String cur = sx[id++];
        if (cur.equals("#")) return null;
        TreeNode x = new TreeNode(Integer.valueOf(cur));
        x.left = dc();
        x.right = dc();
        return x;
    }
}
