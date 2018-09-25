package Learn.LinkedList;

import org.junit.Test;

/**
 * 旋转链表
 *
 * @author zhongtao on 2018/9/22
 */
public class RotateList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        //获取总长度
        for (i = 0; fast.next != null; i++)//Get the total length
            fast = fast.next;

        //获取需要旋转的长度
        for (int j = i - k % i; j > 0; j--) //Get the i-n%i th node
            slow = slow.next;

        //进行旋转
        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        //把它变成一个小圆，从远离头部的k开始
        //make it a cricle, break from k postion far from the head
        ListNode index = head;
        //将列表长度记录下来
        int len = 1;// int len to record the length of list
        while (index.next != null) {
            index = index.next;
            len++;
        }
        index.next = head;

        for (int i = 0; i < len - k % len; i++) {
            index = index.next;
        }
        ListNode result = index.next;
        index.next = null;
        return result;
    }


    /**
     * 测试
     */
    @Test
    public void test(){
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(3);
        listNode2.next.next.next = new ListNode(4);
        listNode2.next.next.next.next = new ListNode(5);
        listNode2.next.next.next.next.next = new ListNode(6);
        listNode2.next.next.next.next.next.next = new ListNode(7);


        ListNode listNode = rotateRight(listNode2, 2);

        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

}
