package Learn.linkedList;

/**
 * 反转链表
 *
 * @author zhongtao on 2018/9/6
 */
public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 按照原始顺序迭代节点，并将它们移动到列表的头部。
     * 1、一个prev来存新链表
     * 2、curr老链表
     * 3、temp中间链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}
