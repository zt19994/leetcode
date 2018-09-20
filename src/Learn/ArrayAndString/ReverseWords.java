package Learn.ArrayAndString;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/**
 * 把一个字符串的单词反过来
 *
 * @author zhongtao on 2018/9/20
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if (Objects.equals("", s.trim())) {
            return s.trim();
        }
        //" +" 多个空格也分割
        String[] strings = s.trim().split(" +");
        int i = 0;
        int j = strings.length - 1;
        while (i < j) {
            String temp = strings[i];
            strings[i] = strings[j];
            strings[j] = temp;
            i++;
            j--;
        }
        return String.join(" ", strings);
    }


    /**
     * 使用工具类
     */
    public String reverseWords1(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    /**
     * 测试
     */
    @Test
    public void test() {
        String s = " 1";
        String reverseWords = reverseWords(s);
        System.out.println(reverseWords);
    }
}
