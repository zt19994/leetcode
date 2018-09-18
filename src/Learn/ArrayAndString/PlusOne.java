package Learn.ArrayAndString;

import org.junit.Test;

/**
 * 加1
 * <p>
 * 给定一个非空的数字数组，表示一个非负整数，加上1到整数。
 * 这些数字被存储起来，使得最重要的数字位于列表的头部，数组中的每个元素都包含一个数字。
 * 你可以假设这个整数不包含任何前导零，除了数字0本身
 *
 * @author zhongtao on 2018/8/24
 */
public class PlusOne {
    //[1,2,3] [4,3,2,1] [4,3,2,9],[9,9,9,9]
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newInts = new int[length + 1];
        newInts[0] = 1;
        return newInts;
    }

    /**
     * 测试plus one
     */
    @Test
    public void testPlusOne() {
        int[] difits = {9, 9, 9, 9};
        int[] ints = plusOne(difits);
        System.out.println(ints);
    }
}
