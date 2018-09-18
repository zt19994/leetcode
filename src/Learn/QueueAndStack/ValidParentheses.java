package Learn.QueueAndStack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 题目20 有效的括号 使用stack
 * 左右括号要对应
 *
 * @author zhongtao on 2018/8/15
 */
public class ValidParentheses {

    /**
     * 使用stack
     * 1、使用map，让左右括号与正负数组相对应
     * 2、遍历校验的括号字符串
     * 3、如果括号对应的数字小于0，则加入到stack
     * 4、如果括号对应的数字大于0，讨论情况
     * 5、stack的size为0，则表示没有与之对应的反括号，返回false
     * 6、stack的size不为0，但是反括号对应的数字与当前括号的和不为0，则括号不对应，返回false
     * 7、遍历括号字符串结束后判断stack大小是否为0，为0，则所有括号对应成功返回true，大于0，则表示还有括号为对应，返回false
     */
    public static boolean isValid(String s) {
        Map<Object, Integer> map = new HashMap<>();
        map.put('(', -1);
        map.put(')', 1);
        map.put('[', -2);
        map.put(']', 2);
        map.put('{', -3);
        map.put('}', 3);

        Stack<Object> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Integer value = map.get(s.charAt(i));
            if (value < 0) {
                stack.add(s.charAt(i));
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                if ((map.get(stack.pop()) + value) != 0) {
                    return false;
                }
            }
        }
        return stack.size() <= 0;
    }


    /**
     * 1、遍历括号字符串
     * 2、如果是左括号，则在stack添加对应的右括号
     * 3、在for循环未结束时，遍历到右括号，但是stack大小为0，即没有对应的左括号，返回false，
     * 4、如果stack最上面的括号，与当前右括号不同，也返回false
     * 5、遍历结束后，如果stack不为返回false，为空返回true
     */
    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    /**
     * 测试有效的括号
     */
    @Test
    public void testIsValid() {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

}
