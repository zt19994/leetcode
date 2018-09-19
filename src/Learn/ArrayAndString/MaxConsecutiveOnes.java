package Learn.ArrayAndString;

import org.junit.Test;

/**
 * 二进制数组中最大连续数 1s
 *
 * @author zhongtao on 2018/9/19
 */
public class MaxConsecutiveOnes {

    /**
     * 判断是否是最长的连续数
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                k++;
                result = k > result ? k : result;
            } else {
                k = 0;
            }
        }
        return result;
    }

    /**
     * 测试
     */
    @Test
    public void test() {
        int[] nums = {1, 1, 1, 0, 0, 0, 1};
        int i = findMaxConsecutiveOnes(nums);
        System.out.println(i);
    }
}
