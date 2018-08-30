package Learn.linkedList;

/**
 * 设计链表
 *
 * @author zhongtao on 2018/8/27
 */
public class MyLinkedList {
    class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head, tail;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size || index < 0) return -1;
        if (index >= size >> 1) {
            Node p = tail;
            int count = size;
            while (count != index) {
                p = p.prev;
                count--;
            }
            return p.val;
        } else {
            Node p = head;
            int count = -1;
            while (count != index) {
                p = p.next;
                count++;
            }
            return p.val;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = new Node(val);
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node node = new Node(val), p;
        if (index >= size >> 1) {
            int count = size;
            p = tail;
            while (count != index) {
                p = p.prev;
                count--;
            }
        } else {
            int count = -1;
            p = head;
            while (count != index) {
                p = p.next;
                count++;
            }
        }
        node.prev = p.prev;
        p.prev.next = node;
        node.next = p;
        p.prev = node;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node p;
        if (index >= size >> 1) {
            int count = size;
            p = tail;
            while (count != index) {
                p = p.prev;
                count--;
            }
        } else {
            int count = -1;
            p = head;
            while (count != index) {
                p = p.next;
                count++;
            }
        }
        p.prev.next = p.next;
        p.next.prev = p.prev;
        p.next = null;
        p.prev = null;
        size--;
    }


    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
}
