package Learn.LinkedList;

/**
 * 合并两个有序链表
 * <p>
 * 合并两个已排序的链表，并将其作为一个新列表返回。新的列表应该通过将前两个列表的节点拼接在一起。
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @author zhongtao on 2018/9/21
 */
public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归函数本身来合并链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 构建一个新链表来存储
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode returnNode = new ListNode(-1); // 初始化返回数组
        ListNode headNode = returnNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                returnNode.next = l1;
                l1 = l1.next; //缩短链表长度
            } else {
                returnNode.next = l2;
                l2 = l2.next;
            }
            returnNode = returnNode.next;
        }
        // 当其中一个链表为空时
        if (l1 == null) {
            returnNode.next = l2;
        } else if (l2 == null) {
            returnNode.next = l1;
        }
        return headNode.next;
    }
}
