package Learn.QueueAndStack;

import org.junit.Test;

import java.util.Stack;

/**
 * 测试内置stack库
 *
 * @author zhongtao on 2018/8/30
 */
public class StackTest {
    /**
     * 测试内置stack库的基本操作
     */
    @Test
    public void testStack() {
        // 1. Initialize a stack. 初始化stack
        Stack<Integer> s = new Stack<>();
        // 2. Push new element. 添加新元素
        s.push(5);
        s.push(13);
        s.push(8);
        s.push(6);
        // 3. Check if stack is empty. 检查 stack 是否为空
        if (s.empty() == true) {
            System.out.println("Stack is empty!");
            return;
        }
        // 4. Pop an element. 弹出 stack 的一个元素
        s.pop();
        // 5. Get the top element. 获取 stack 最上面的元素
        System.out.println("The top element is: " + s.peek());
        // 6. Get the size of the stack. 获取 stack 的大小
        System.out.println("The size is: " + s.size());
    }
}
