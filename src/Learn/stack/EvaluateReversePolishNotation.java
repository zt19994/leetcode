package Learn.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 逆波兰表示法进行评估
 *
 * @author zhongtao on 2018/8/30
 */
public class EvaluateReversePolishNotation {

    /**
     * 遇到符号时，把最后两个数拿来计算 使用stack
     */
    public int evalRPN(String[] a) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < a.length; i++) {
            switch (a[i]) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    int n1 = stack.pop(), n2 = stack.pop();
                    stack.push(n2 / n1);
                    break;

                default:
                    stack.push(Integer.parseInt(a[i]));
            }
        }

        return stack.pop();
    }


    private int index;

    /**
     * 倒序递归法
     */
    public int evalRPN1(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        index = tokens.length - 1;
        return cal(tokens);
    }

    private int cal(String[] tokens) {
        switch (tokens[index--]) {
            case "+":
                return cal(tokens) + cal(tokens);
            case "-":
                return -1 * cal(tokens) + cal(tokens);
            case "*":
                return cal(tokens) * cal(tokens);
            case "/":
                return (int) (1.0 / cal(tokens) * cal(tokens));
            default:
                return Integer.valueOf(tokens[index + 1]);
        }
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        String[] a = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int i = evalRPN1(a);
        System.out.println(i);
    }
}
