package Learn.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用 queue 实现 stack
 * @author zhongtao on 2018/8/31
 */
public class MyStack1 {
    //one Queue solution 使用一个队列
    private Queue<Integer> q = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
        for(int i = 1; i < q.size(); i ++) {
            //rotate the queue to make the tail be the head 将队列反转
            q.add(q.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
