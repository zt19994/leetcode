package Learn.ArrayAndString;

import org.junit.Test;

/**
 * 把一个字符串的单词反过来3
 * <p>
 * 给定一个字符串，您需要在一个句子中颠倒每个单词中的字符顺序，同时保留空格和初始单词顺序。
 *
 * @author zhongtao on 2018/9/20
 */
public class ReverseWords3 {

    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        for (int i = 0; i < split.length; i++) {
            String reverseString = reverseString(split[i]);
            split[i] = reverseString;
        }

        return String.join(" ", split);
    }


    //反转字符
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
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
    public void test() {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
