package Learn.ArrayAndString;

import org.junit.Test;

/**
 * 反转字符串
 *
 * @author zhongtao on 2018/9/15
 */
public class ReverseString {

    /**
     * 双指针
     */
    public String reverseString(String s){
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j){
            char temp = chars[j];
            chars[j] = chars[i];
            chars[i] = temp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }


    /**
     * 测试
     */
    @Test
    public void test(){
        String s = "abcde";
        String s1 = reverseString(s);
        System.out.println(s1);
    }
}
