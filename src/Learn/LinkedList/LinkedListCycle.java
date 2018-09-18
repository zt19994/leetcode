package Learn.LinkedList;

/**
 * 链表循环
 *
 * @author zhongtao on 2018/9/3
 */
public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * 1、Use two pointers, walker and runner.
     * 2、walker moves step by step. runner moves two steps at time.
     * 3、if the Linked List has a cycle walker and runner will meet at somepoint.
     */
    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next!=null&& runner.next.next!=null){
            walker = walker.next;
            runner = runner.next.next;
            if (walker==runner){
                return true;
            }
        }
        return false;
    }
}
