package Learn.QueueAndStack;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个支持push、pop、top和在常量时间中检索最小元素的堆栈。
 * 使用for循环来找最小值，效率低
 *
 * @author zhongtao on 2018/8/21
 */
public class MinStack1 {

    List<Integer> list;

    int min;

    /**
     * initialize your data structure here.
     */
    public MinStack1() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        min = top();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
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