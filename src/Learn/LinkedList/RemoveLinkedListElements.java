package Learn.LinkedList;

import org.junit.Test;

/**
 * 移除链表中指定元素
 *
 * @author zhongtao on 2018/9/6
 */
public class RemoveLinkedListElements {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }


    /**
     * 测试删除链表元素
     * Input:  1->2->6->3->4->5->6, val = 6
     * Output: 1->2->3->4->5
     */
    @Test
    public void test(){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next.next = new ListNode(6);
        ListNode removeElements = removeElements(listNode, 6);

        while (removeElements!=null){
            System.out.print(removeElements.val + " ");
            removeElements = removeElements.next;
        }
        System.out.println();
    }


    /**
     * 测试值传递
     */
    @Test
    public void test2(){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);

        listNode.next = listNode.next.next;

        System.out.println(listNode);

    }
}
