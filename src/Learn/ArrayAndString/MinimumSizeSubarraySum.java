package Learn.ArrayAndString;

import org.junit.Test;

/**
 * 最小长度数组和
 *
 * @author zhongtao on 2018/9/19
 */
public class MinimumSizeSubarraySum {

    /**
     * 两层for循环，有点慢
     */
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    k = j - i + 1;
                    result = k < result ? k : result;
                    break;
                }
            }
        }
        return result < Integer.MAX_VALUE ? result : 0;
    }

    /**
     * 双指针，快速
     */
    public int minSubArrayLen1(int s, int[] nums) {
        int result = 0;
        int start = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum - nums[start] >= s) {
                sum -= nums[start];
                start++;
            }

            //获取最小值
            if (sum >= s) {
                if (result == 0 || result > i - start + 1) {
                    result = i - start + 1;
                }
            }
        }
        return result;
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        int[] nums = {2, 3, 1, 2, 4, 3, 7};
        int i = minSubArrayLen(7, nums);
        int j = minSubArrayLen1(7, nums);
        System.out.println(i + "  " + j);
    }
}
