package Learn.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 每天的温度
 * 给出一个每日温度的列表，列出一个清单，遍历每一天，告诉你需要多少天才能等到温度升高。
 * 如果未来没有温度升高的一天，这是可能的，那么就把0放在这里。
 * 例子：假设列表的温度=[73 74 75 71 69 72 76 73]，输出应该是[1 1 4 2 1 1 0 0]。
 * 即73等一天温度升高，74等一天升高。。。71等2天升高。。。76未来不会升高了
 *
 * @author zhongtao on 2018/8/22
 */
public class DailyTemperatures {

    /**
     * 方法一：嵌套循环
     * 1、遍历温度列表
     * 2、遍历该温度后面的温度列表
     * 3、当发现小于此温度的温度是，用索引相减，获取需要等待的天数
     * 4、如果遍历结束都为发现大于的温度，则为0
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
                    days[i] = 0;
                }
            }
        }
        return days;
    }

    /**
     * 方法二：使用栈
     * 用stack在存储索引
     */
    public int[] daliyTemperatures2(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer val = stack.pop();
                //升高温度天索引 - 目标天索引
                result[val] = i - val;
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * 方法三：模拟栈，使用栈的思想
     *
     */
    public int[] dailyTemperatures3(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--];
                result[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return result;
    }


    /**
     * 测试
     */
    @Test
    public void test(){
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = daliyTemperatures2(temperatures);
        System.out.println(ints);
    }
}
