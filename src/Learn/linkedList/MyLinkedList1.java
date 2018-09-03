package Learn.linkedList;

/**
 * 设计链表 单链表
 * @author zhongtao on 2018/8/27
 */
public class MyLinkedList1 {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head;
    int length;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList1() {
        this.length = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        index++;
        if (index > length) {
            return -1;
        }
        Node current = head;
        while (index-- > 1) {
            current = current.next;
        }
        return current.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(this.length, val);

    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > length - 1) {
            return;
        }
        Node newNode = new Node(val);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (index > 1) {
                current = current.next;
                index--;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        length++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (length == 0 || index > length-1) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            while (index > 1) {
                current = current.next;
                index--;
            }
            current.next = current.next.next;
        }
        length--;
    }
}
