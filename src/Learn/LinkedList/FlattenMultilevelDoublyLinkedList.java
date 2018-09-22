package Learn.LinkedList;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * 将多级双链表拉平
 *
 * @author zhongtao on 2018/9/21
 */
public class FlattenMultilevelDoublyLinkedList {

    public class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }


    /**
     * 相当于迭代遍历child
     */
    public Node flatten(Node head) {
        // 指针 pointer
        Node p = head;
        while (p != null) {
            // 没有指针
            if (p.child == null) {
                p = p.next;
                continue;
            }
            //获取子集，找到子集的尾节点，将其和子节点的next节点连接
            Node temp = p.child;
            // 找到子集的尾节点
            while (temp.next != null) {
                temp = temp.next;
            }
            // 将其和子节点的next节点连接
            temp.next = p.next;
            if (p.next != null) {
                p.next.prev = temp;
            }
            // 将p和p的子集连接起来，然后删除p的子集
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }


    /**
     * 迭代法 理解？
     */
    public Node flatten1(Node head) {
        if (head == null) return null;
        return helper(head, new HashMap<Node, Node>());
    }

    private Node helper(Node head, Map<Node, Node> map) {
        Node n = head;
        while (n != null) {
            if (n.child != null) {
                //获取有子集节点的下一个节点
                Node temp = n.next;
                n.next = helper(n.child, map);
                n.next.prev = n;
                n.child = null;
                if (temp == null) {
                    map.put(head, map.get(n.next));
                    return head;
                } else {
                    map.get(n.next).next = temp;
                    temp.prev = map.get(n.next);
                    n = temp;
                }
            } else {
                if (n.next == null) {
                    map.put(head, n);
                }
                n = n.next;
            }
        }
        return head;
    }
}
