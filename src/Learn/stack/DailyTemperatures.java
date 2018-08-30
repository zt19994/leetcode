package Learn.stack;

import java.util.Stack;

/**
 * @author zhongtao on 2018/8/22
 */
public class DailyTemperatures {

    /**
     * 方法一：嵌套循环
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        int size = temperatures.length;
        int[] days = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (temperatures[i] < temperatures[j]) {
                    days[i] = j - i;
                    break;
                } else if (j == temperatures.length - 1) {
                    days[i] = (0);
                }
            }
        }
        return days;
    }

    /**
     * 方法二：使用栈
     *
     * @param temperatures
     * @return
     */
    public int[] daliyTemperatures2(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer val = stack.pop();
                result[val] = i - val;
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * 方法三：模拟栈，使用栈的思想
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures3(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--];
                ret[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return ret;
    }
}
