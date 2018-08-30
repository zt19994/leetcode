package Learn.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 设计一个支持push、pop、top和在常量时间中检索最小元素的堆栈。
 *
 * @author zhongtao on 2018/8/21
 */
public class MinStack2 {
    long min;
    Stack<Long> stack;

    public MinStack2() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);//Could be negative if min value needs to change
            if (x < min) min = x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop = stack.pop();

        if (pop < 0) min = min - pop;//If negative, increase the min value

    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) (min);
        }
    }

    public int getMin() {
        return (int) min;
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        MinStack2 stack2 = new MinStack2();
        stack2.push(-2);
        stack2.push(0);
        stack2.push(-3);
        System.out.println(stack2.getMin());
        stack2.pop();
        System.out.println(stack2.top());
        System.out.println(stack2.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */