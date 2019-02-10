package Learn.Recursion;

/**
 * 成对交换节点
 *
 * @author zt1994 2019/2/10 20:12
 */
public class SwapNodesInPairs {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个链表，每交换两个相邻节点并返回其头部。
     * 您不能修改列表节点中的值，只能修改节点本身。
     * <p>
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }
}
