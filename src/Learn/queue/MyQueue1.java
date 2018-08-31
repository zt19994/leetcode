package Learn.queue;

import java.util.Stack;

/**
 * 通过 stack 实现 queue
 *
 * @author zhongtao on 2018/8/31
 */
public class MyQueue1 {

    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();

    /**
     * Initialize your data structure here.
     */
    public MyQueue1() {
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        input.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        peek();
        return output.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
