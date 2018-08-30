package Learn.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单队列实现 FIFO 先进先出的数据结构
 *
 * @author zhongtao on 2018/8/15
 */
public class MyQueue {
    // store elements 使用列表存储数据
    private List<Integer> data;
    // a pointer to indicate the start position 指向起始位置
    private int p_start;

    //初始化
    public MyQueue() {
        data = new ArrayList<Integer>();
        p_start = 0;
    }

    /**
     * 添加元素到队列，成功返回true
     * Insert an element into the queue. Return true if the operation is successful.
     */
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    /**
     * 从队列中删除元素，成功返回true
     * Delete an element from the queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        p_start++;
        return true;
    }

    /**
     * 获取队列第一个元素
     * Get the front item from the queue.
     */
    public int Front() {
        return data.get(p_start);
    }

    /**
     * 检查队列是否为空或已满，空或已满返回true
     * Checks whether the queue is empty or not.
     */
    public boolean isEmpty() {
        return p_start >= data.size();
    }
}


