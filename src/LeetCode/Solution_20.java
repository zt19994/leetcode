package LeetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 题目20 有效的括号
 * @author zhongtao on 2018/8/15
 */
public class Solution_20 {

    public static boolean isValid(String s) {
        Map<Object, Object> map = new HashMap<>();
        map.put("(", -1);
        map.put(")", 1);
        map.put("[", -2);
        map.put("]", 2);
        map.put("{", -3);
        map.put("}", 3);

        Stack<Object> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String key = String.valueOf(s.charAt(i));
            Integer value = (Integer) map.get(key);
            if (value < 0) {
                stack.add(key);
            } else {
                if (stack.size()==0){
                    return false;
                }
                String last = (String) stack.pop();
                if (((Integer)map.get(last) + value) != 0) {
                    return false;
                }
            }
        }
        return stack.size() <= 0;
    }


    public static boolean isValid2(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '('){
                stack.push(')');
            }else if (c == '['){
                stack.push(']');
            }else if (c == '{'){
                stack.push('}');
            }else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }


    /**
     * 测试有效的括号
     */
    @Test
    public void testIsValid(){
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

}
