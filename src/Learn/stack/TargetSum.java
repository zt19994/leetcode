package Learn.stack;

import org.junit.Test;

/**
 * 目标和
 *
 * @author zhongtao on 2018/8/31
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

    /**
     *
     */
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        int targetSumWays = findTargetSumWays(nums, 1);
        System.out.println(targetSumWays);
    }
}
