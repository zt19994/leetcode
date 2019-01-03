package Learn.BinarySearch;

import org.junit.Test;

/**
 * 找到比目标更大的最小字母
 *
 * @author zhongtao on 2019/1/3
 */
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;

        //hi以“n”开头，而不是通常的“n - 1”。因为循环条件是‘lo < hi’，如果hi从‘n - 1’开始，我们永远不能考虑索引n - 1处的值
        int lo = 0, hi = n;

        //循环条件是'lo < hi', 避免target值小于第一个元素
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        //因为lo最终指向index 'n'，在这种情况下我们返回第一个元素
        return letters[lo % n];
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        char[] letters = new char[]{'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(letters, 'a'));
    }
}
