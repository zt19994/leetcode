package Learn.QueueAndStack;

import org.junit.Test;

/**
 * 使用链表来实现
 *
 * @author zhongtao on 2018/8/30
 */
public class MinStack3 {

    class Node {
        public int value;
        public int min;
        //下一个节点
        public Node next;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    public Node top;

    public MinStack3() {

    }

    public void push(int x) {
        if (top == null) {
            top = new Node(x, x);
        } else {
            Node newNode = new Node(x, Math.min(x, top.min));
            newNode.next = top;
            top = newNode;
        }
    }

    public void pop() {
        if (top == null) {
            return;
        } else {
            top = top.next;
        }
    }

    public int top() {
        if (top == null) {
            return -1;
        } else {
            return top.value;
        }
    }

    public int getMin() {
        if (top == null) {
            return -1;
        } else {
            return top.min;
        }
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        MinStack3 stack3 = new MinStack3();
        stack3.push(-2);
        stack3.push(0);
        stack3.push(-3);
        System.out.println(stack3.getMin());
        stack3.pop();
        System.out.println(stack3.top());
        System.out.println(stack3.getMin());
    }
}
