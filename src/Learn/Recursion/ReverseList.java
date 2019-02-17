package Learn.Recursion;

/**
 * 反转链表
 *
 * @author zt1994 2019/2/11 15:22
 */
public class ReverseList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 递归反转链表
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
