package Learn.LinkedList;

import org.junit.Test;

/**
 * 添加两个数字
 * <p>
 * 给您两个非空链表，表示两个非负整数。这些数字以相反的顺序存储，每个节点都包含一个数字。将两个数字相加，并将其作为链表返回。
 * 你可以假设这两个数字不包含任何前导零，除了数字0本身。
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author zhongtao on 2018/9/21
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0;
        int k = 1;
        while (l1 != null) {
            num1 += l1.val * k;
            l1 = l1.next;
            k *= 10;
        }

        int num2 = 0;
        int s = 1;
        while (l2 != null) {
            num1 += l2.val * s;
            l2 = l2.next;
            s *= 10;
        }

        int sum = num1 + num2;
        if (sum == 0) {
            return new ListNode(0);
        }

        ListNode returnNode = new ListNode(0);
        ListNode headNode = returnNode;
        while (sum != 0) {
            returnNode.next = new ListNode(sum % 10);
            sum = sum / 10;
            returnNode = returnNode.next;
        }
        return headNode.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }


    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0; //进位
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        return head.next;
    }

    /**
     * 测试
     * [9]
     * [1,9,9,9,9,9,9,9,9,9]
     */
    @Test
    public void test() {
        ListNode listNode1 = new ListNode(9);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode(9);
        listNode2.next.next.next = new ListNode(9);
        listNode2.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next = new ListNode(1);

        ListNode listNode = addTwoNumbers(listNode1, listNode2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    @Test
    public void test1() {
        ListNode listNode1 = new ListNode(9);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode(9);
        listNode2.next.next.next = new ListNode(9);
        listNode2.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next = new ListNode(1);

        ListNode listNode = addTwoNumbers2(listNode1, listNode2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


}
