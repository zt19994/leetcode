package Learn.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 解码字符串
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 * @author zhongtao on 2018/8/31
 */
public class DecodeString {

    /**
     * 1、res存放单个[]中的字符
     * 2、countStack存放数字
     * 3、resStack存放处理过的字符串
     * 4、循环判断字符串是否是数字，是数字就存放在countStack中
     * 5、是[括号，先把res存放在resStack然后res设为空
     * 6、如果是英文字符就添加到res上
     * 7、如果是]括号，取出resStack中的字符串temp，和countStack中的数字num，while循环在temp上添加num次res，保存为res
     */
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }


    public String decodeString1(String s) {
        Stack<String> st = new Stack<>();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int start = i;
            while (s.charAt(i) >= '0' && s.charAt(i) <= '9') i++;
            if (start != i) st.push(s.substring(start, i)); //截取数字
            switch (s.charAt(i)) {
                case '[':
                    st.push("[");
                    break;
                case ']':
                    popString(st);
                    break;
                default:
                    st.push(s.substring(i, i + 1));
            }
        }
        while (!st.empty()) {
            res = st.pop() + res;
        }
        return res;
    }

    public void popString(Stack<String> st) {
        if (!st.empty()) {
            String tail = "";
            while (!st.peek().equals("[")) tail = st.pop() + tail;
            st.pop(); //弹出[
            int k = Integer.valueOf(st.pop());
            String res = "";
            while (k-- > 0) res += tail;
            st.push(res);
        }
    }

    public String decodeString2(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int index = 0;
        while(index < s.length()){
            if(s.charAt(index)>='0' && s.charAt(index)<='9'){
                int count = 0;
                while(s.charAt(index)>='0' && s.charAt(index)<='9'){
                    count = 10*count + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            }else if(s.charAt(index)=='['){
                resStack.push(res);
                res = "";
                index++;
            }else if(s.charAt(index)==']'){
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                while(repeatTimes-->0){
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            }else{
                res += s.charAt(index++);
            }
        }
        return res;
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        String result = decodeString("2[ab]3[c]4[h]");
        System.out.println(result);
    }

    /**
     *
     */
    @Test
    public void test1() {
        String result1 = decodeString1("2[ab]3[c]4[h]");
        System.out.println(result1);
    }
    
    
    /**
     * 
     */
    @Test
    public void test2(){
        System.out.println(decodeString2("3[a]2[bc]"));
    }
}
