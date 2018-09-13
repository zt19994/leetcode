### Queue 队列：First-in-first-out Data Structure（FIFO）
#### 1.FIFO 和 queue 的定义

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/05/03/screen-shot-2018-05-03-at-151021.png" width="60%">

&emsp;&emsp;FIFO 数据结构，即第一个添加到队列的元素，第一个进行处理。<br>
&emsp;&emsp;queue 队列是典型的 FIFO 数据结构。插入操作也称为enqueue，新元素总是在队列的末尾添加。删除操作称为dequeue。您只被允许删除第一个元素。
#### 2.实现一个简单 queue
##### 简单的queue
&emsp;&emsp;为了实现一个队列，我们可以使用一个动态数组和一个指向队列头部的索引。如上所述，队列应该支持两个操作：enqueue 和 dequeue。Enqueue 将一个新元素附加到队列中，而 dequeue 删除第一个元素。所以我们需要一个索引来表示起始点。
```java
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
```
测试MyQueue：
```java
public class TestQueue {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
    }
}
```
&emsp;&emsp;上面的实现很简单，但在某些情况下效率低下。随着开始指针的移动，越来越多的空间被浪费了。当我们有空间限制时，这是不可接受的。
#### 3、实现循环队列 circular queue
&emsp;&emsp;更有效的方法是使用循环队列。具体地说，我们可以使用一个固定大小的数组和两个指针来指定起始位置和结束位置。我们的目标是重用我们之前提到的浪费的存储。<br>
&emsp;&emsp;在一个循环队列中，我们使用一个数组和两个指针，head和tail。head表示队列的开始位置，而tail则表示队列的结束位置。
```java
public class MyCircularQueue {

    private int[] data;
    //头部索引
    private int p_start = 0;
    //尾部索引
    private int p_tail = -1;
    //长度
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

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
```
##### 注意：初始化 p_start 时是 0；
#### 3.熟悉内置的队列结构
&emsp;&emsp;java 中内置的 queue 结构，不用再重复造轮子。Queue 继承 Collection。如前所述，队列有两个重要的操作，enqueue和dequeue。此外，我们应该能够获得队列中的第一个元素，因为第一个元素应该首先处理。
```java
public class TestBuiltInQueue {
    public static void main(String[] args) {
        // 1. Initialize a queue. 初始化一个队列
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty. 获取第一个元素，空返null
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
        // 7. Get the size of the queue. 获取队列大小
        System.out.println("The size is: " + q.size());
    }
}
```
