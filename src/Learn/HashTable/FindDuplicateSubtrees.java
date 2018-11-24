package Learn.HashTable;

import java.util.*;

/**
 * 发现重复的子树
 * <p>
 * Given a binary tree, return all duplicate subtrees.
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * <p>
 * Two trees are duplicate if they have the same structure with same node values.
 *
 * @author zhongtao on 2018/11/22
 */
public class FindDuplicateSubtrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 使用map
     *
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postOrder(root, new HashMap<>(), res);
        return res;
    }

    public String postOrder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) {
            return "#";
        }
        //StringBuffer sb = new StringBuffer();
        //sb.append(cur.val).append(",").append(postOrder(cur.left, map, res)).append(",").append(postOrder(cur.right, map, res));
        String serial = cur.val + "," + postOrder(cur.left, map, res) + "," + postOrder(cur.right, map, res);
        if (map.getOrDefault(serial, 0) == 1) {
            res.add(cur);
        }
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }

    /**
     * 使用set
     *
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        helper(root, map, set);
        return new ArrayList<>(set);
    }

    private String helper(TreeNode root, Map<String, Integer> map, Set<TreeNode> set) {
        if (root == null) {
            return "#";
        }
        String left = helper(root.left, map, set);
        String right = helper(root.right, map, set);
        String key = root.val + left + right;

        if (map.containsKey(key) && map.get(key) == 1) {
            set.add(root);
            map.put(key, map.get(key) + 1);
        } else if (!map.containsKey(key)) {
            map.put(key, 1);
        }
        return key;
    }
}
