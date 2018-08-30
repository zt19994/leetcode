package Learn.stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用动态数组实现堆栈
 *
 * @author zhongtao on 2018/8/30
 */
public class MyStack {
    // store elements 使用动态数组存储元素
    private List<Integer> data;

    public MyStack() {
        data = new ArrayList<>();
    }

    /**
     * 在 stack 中插入元素
     * Insert an element into the stack.
     */
    public void push(int x) {
        data.add(x);
    }

    /**
     * 检查 stack 是否为空 空返回 true
     * Checks whether the queue is empty or not.
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 获取 stack 最上面的元素
     * Get the top item from the queue.
     */
    public int top() {
        return data.get(data.size() - 1);
    }

    /**
     * 删除 stack 中的一个元素，成功返回 true
     * Delete an element from the queue. Return true if the operation is successful.
     */
    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        data.remove(data.size() - 1);
        return true;
    }

    /**
     * 测试堆栈
     */
    @Test
    public void testMyStack() {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);
        for (int i = 0; i < 4; ++i) {
            if (!s.isEmpty()) {
                System.out.println(s.top());
            }
            System.out.println(s.pop());
        }
    }
}
