package Learn.linkedList;

import org.junit.Test;

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

    /**
     * 测试反转链表
     */
    @Test
    public void test(){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);

        ListNode reverseList = reverseList(listNode);

        System.out.println(reverseList);

    }

}
