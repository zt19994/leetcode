package Learn.Recursion;

import org.junit.Test;

/**
 * 反转字符串
 *
 * @author zt1994 2019/2/10 15:47
 */
public class ReverseString {

    /**
     * 编写一个反转字符串的函数。输入字符串是一个字符char[]数组。
     * 不要为另一个数组分配额外的空间，必须使用O(1)额外内存修改输入数组。
     * 您可以假设所有字符都由可打印的ascii字符组成。
     * <p>
     * Input: ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     * <p>
     * Input: ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     */
    public void reverseString(char[] s) {
        helper(0, s.length - 1, s);
    }

    private void helper(int left, int right, char[] s) {
        if (s == null || left > right) {
            return;
        }
        helper(left + 1, right - 1, s);
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

    /**
     * 测试反转字符串数组
     */
    @Test
    public void test() {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        for (char c : s) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

}
