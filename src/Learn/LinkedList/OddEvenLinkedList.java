package Learn.LinkedList;

import org.junit.Test;

/**
 * 将链表中奇数偶数分别组合排在一起，要按顺序
 *
 * @author zhongtao on 2018/9/12
 */
public class OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head, even = head.next, evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }


    @Test
    public void test(){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next = new ListNode(2);
        listNode.next.next.next.next.next.next = new ListNode(1);

        ListNode node = oddEvenList(listNode);

        while (node !=null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();

    }
}
