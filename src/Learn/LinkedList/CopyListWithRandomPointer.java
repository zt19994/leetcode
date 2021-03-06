package Learn.LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 代随机指针的拷贝列表
 * <p>
 * 给出了一个链表，这样每个节点都包含一个额外的随机指针，它可以指向列表中的任何节点或null。
 * 返回一份清单的深层副本。
 *
 * @author zhongtao on 2018/9/22
 */
public class CopyListWithRandomPointer {

    public class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        // loop 1. copy all the nodes 复制所有节点
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        // loop 2. assign next and random pointers 分配下一个和随机指针
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }


    public RandomListNode copyRandomList1(RandomListNode head) {
        if(head == null){return null;}
        HashSet<RandomListNode> nodes = new HashSet<>();
        HashMap<RandomListNode, RandomListNode> hashmap = new HashMap<>();

        nodes = copyNodes(head);
        for(RandomListNode node: nodes){
            hashmap.put(node, new RandomListNode(node.label));
        }
        for(RandomListNode node:nodes){
            RandomListNode newNode = hashmap.get(node);
            newNode.next = hashmap.get(node.next);
            newNode.random = hashmap.get(node.random);
        }
        return hashmap.get(head);
    }

    private HashSet copyNodes(RandomListNode node){
        HashSet<RandomListNode> set = new HashSet<>();
        if(node == null){return null;}
        while(node!= null){
            set.add(node);
            node = node.next;
        }
        return set;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        RandomListNode iter = head, next;

        // First round: make copy of each node, 第一轮：复制每个节点，
        // and link them together side-by-side in a single list. 并将它们并列在一个列表中。
        while (iter != null) {
            next = iter.next;

            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes. 第二轮：为复制节点分配随机指针。
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list. 第三轮：恢复原始列表，并提取副本列表。
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }


    public RandomListNode copyRandomList3(RandomListNode head) {
        RandomListNode first = head;
        RandomListNode second = head;

        while( first!=null ){
            second = first.next;
            RandomListNode temp = new RandomListNode(first.label);
            first.next = temp;
            temp.next = second;
            first = second;
        }

        first = head;

        while( first!=null ){
            if( first.random !=null ){
                first.next.random = first.random.next;
            }
            first = first.next.next;
        }

        RandomListNode root = new RandomListNode(0);
        RandomListNode rootTemp = root;

        first = head;

        while( first!=null ){
            rootTemp.next = first.next;
            first.next = first.next.next;
            first = first.next;
            rootTemp = rootTemp.next;
        }

        return root.next;
    }
}
