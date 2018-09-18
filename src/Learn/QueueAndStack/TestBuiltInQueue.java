package Learn.QueueAndStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 测试内置队列
 *
 * @author zhongtao on 2018/8/16
 */
public class TestBuiltInQueue {
    public static void main(String[] args) {
        // 1. Initialize a QueueAndStack. 初始化一个队列
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if QueueAndStack is empty. 获取第一个元素，空返null
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element. 添加新元素
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element. 弹出一个元素
        q.poll();
        // 5. Get the first element. 获取第一个元素
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the QueueAndStack. 获取队列大小
        System.out.println("The size is: " + q.size());
    }
}
