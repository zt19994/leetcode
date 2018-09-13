### Stack 堆栈 ：Last-in-first-out Data Structure 
#### 1、Stack 介绍

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/06/03/screen-shot-2018-06-02-at-203523.png" width="60%">

&emsp;&emsp;在 LIFO 数据结构中，最新添加到队列的元素将被最先处理。和 queue 不同， stack 是一种 LIFO 的数据类型。通常，插入操作被称为栈中的 push。与队列相似，总是在堆栈的末尾添加一个新元素。然而，删除操作 pop，与队列相反，总是会删除最后一个元素。

### 2、Stack 实现
&emsp;&emsp;堆栈的实现比队列更容易。一个动态数组足以实现堆栈结构。

java 代码实现：
```java
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
```
### 3、stack 的使用
&emsp;&emsp;许多流行的编程语言都提供内置的堆栈库，所有你不用重复造轮子。除了初始化，我们还需要知道如何使用两个最重要的操作，pop 和 push。同样，你应该能够得到最上面的元素。

java实例代码：
```java
public class StackTest {
    /**
     * 测试内置stack库的基本操作
     */
    @Test
    public void testStack(){
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
```
&emsp;&emsp;当您想要首先处理最后一个元素时，堆栈将是最合适的数据结构。