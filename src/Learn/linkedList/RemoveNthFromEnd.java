package Learn.linkedList;

/**
 * 移除链表指定位置节点
 *
 * @author zhongtao on 2018/9/5
 */
public class RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    //还是走的快的点(fastNode)与走得慢的点(slowNode)路程差的问题
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode headNode = new ListNode(9527);
        headNode.next = head;
        ListNode fastNode = headNode;
        ListNode slowNode = headNode;
        while(fastNode.next != null){
            if(n <= 0){
                slowNode = slowNode.next;
            }
            fastNode = fastNode.next;
            n--;
        }
        if(slowNode.next != null)
            slowNode.next = slowNode.next.next;
        return headNode.next;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if ( head == null ) { return head; }

        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head, fast = dummy, prev = dummy;
        for ( int i = 0; i < n; i++ ) {
            fast = fast.next;
        }
        while ( fast.next != null ) {
            fast = fast.next;
            slow = slow.next;
            prev = prev.next;
        }
        prev.next = slow.next;
        return dummy.next;

    }
}
