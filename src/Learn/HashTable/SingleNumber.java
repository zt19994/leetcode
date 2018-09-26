package Learn.HashTable;

import org.junit.Test;

/**
 * 单个数字
 *
 * @author zhongtao on 2018/9/26
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));

        System.out.println(1^1^2^3^2);
    }
}
