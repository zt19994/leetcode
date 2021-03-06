package Learn.QueueAndStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 克隆一个无向图。图中的每个节点都包含一个标签和它的邻居列表
 *
 * @author zhongtao on 2018/8/30
 */
public class CloneGraph {

    //无向图
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

    /**
     * 克隆无向图 递归法
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }


    /**
     * 克隆原理一样
     */
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {

        if (node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return helper(map, node);
    }

    private UndirectedGraphNode helper(HashMap<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {

        UndirectedGraphNode n = new UndirectedGraphNode(node.label);
        map.put(node, n);
        for (UndirectedGraphNode val : node.neighbors) {
            if (map.containsKey(val)) {
                n.neighbors.add(map.get(val));
            } else {
                UndirectedGraphNode tmp = helper(map, val);
                n.neighbors.add(tmp);
            }
        }

        return n;
    }
}
