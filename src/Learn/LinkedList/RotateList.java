package Learn.LinkedList;

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
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)//Get the total length
            fast=fast.next;

        for (int j=i-k%i;j>0;j--) //Get the i-n%i th node
            slow=slow.next;

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if(head==null||head.next==null||k==0) return head;

        //make it a cricle, break from k postion far from the head
        ListNode index=head; int len=1;// int len to record the length of list
        while(index.next!=null)
        {index=index.next; len++;}
        index.next=head;

        for(int i=0;i<len-k%len;i++)
        {
            index=index.next;
        }
        ListNode result=index.next;
        index.next=null;
        return result;
    }
}
