package Learn.linkedList;

import org.junit.Test;

/**
 * 判断linked是否是回文
 *
 * @author zhongtao on 2018/9/12
 */
public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 1、找到链表的前半部分
     * 2、比较前后链表是否一样
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head, rev = null;
        while (fast != null && fast.next != null) {
            ListNode temp = rev;
            rev = slow;
            slow = slow.next;
            //走2步，可以确定循环次数
            fast = fast.next.next;
            rev.next = temp;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (rev != null) {
            if (slow.val != rev.val) {
                return false;
            }
            slow = slow.next;
            rev = rev.next;
        }
        return true;
    }


    public boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head, rev = null;
        while (fast != null && fast.next != null) {
            ListNode temp = rev;
            rev = slow;
            slow = slow.next;
            fast = fast.next.next;
            rev.next = temp;
        }
        ListNode tail = fast != null ? slow.next : slow;
        while (rev != null) {
            if (tail.val != rev.val) {
                return false;
            }
            ListNode temp = slow;
            slow = rev;
            tail = tail.next;
            rev = rev.next;
            slow.next = temp;
        }
        return true;
    }

    /**
     * 递归方法
     * 最前面的节点和最后面的节点比较
     */
    ListNode front;
    public boolean isPalindrome2(ListNode head) {
        front = head;
        return help(head);
    }

    private boolean help(ListNode tail) {
        if (tail == null)
            return true;

        if (help(tail.next) && front.val == tail.val) {
            front = front.next;
            return true;
        }

        return false;
    }

    /**
     * 测试回文链表
     */
    @Test
    public void test(){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next = new ListNode(2);
        listNode.next.next.next.next.next.next = new ListNode(1);

        //boolean palindrome = isPalindrome(listNode);
        boolean palindrome2 = isPalindrome2(listNode);

        System.out.println(palindrome2);

    }
}
