package Learn.queue;

/**
 * 循环队列 避免浪费存储空间
 * 两个指针
 *
 * @author zhongtao on 2018/8/15
 */
public class MyCircularQueue {

    private int[] data;
    //头部索引
    private int p_start = 0;
    //尾部索引
    private int p_tail = -1;
    //存储长度
    private int len = 0;

    /**
     * 初始化队列，设置队列大小
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        data = new int[k];
    }

    /**
     * 添加元素到队列，成功返回true
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            // 6 % 5 = 1  即可以在索引1处添元素，实现循环添加元素
            p_tail = (p_tail + 1) % data.length;
            data[p_tail] = value;
            len++;
            return true;
        }

    }

    /**
     * 从队列中删除元素，成功返回true
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            p_start = (p_start + 1) % data.length;
            len--;
            return true;
        }

    }

    /**
     * 获取队列第一个元素
     * Get the front item from the queue.
     */
    public int Front() {
        return isEmpty() ? -1 : data[p_start];
    }

    /**
     * 获取队列最后一个元素
     * Get the last item from the queue.
     */
    public int Rear() {
        return isEmpty() ? -1 : data[p_tail];
    }

    /**
     * 检查循环队列是否为空，空返回true
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return len == 0;
    }

    /**
     * 检查循环队列是否已满，满返回true
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return len == data.length;
    }
}