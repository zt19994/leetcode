package Learn.LinkedList;

/**
 * 两个链表的交叉
 *
 * @author zhongtao on 2018/9/5
 */
public class IntersectionOfTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 获取链表交叉，不用计算链表长度
     *
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            //相当于减长度
            a = a==null? headB: a.next;
            b = b==null? headA: b.next;
        }
        return a;
    }
}
