package Learn.QueueAndStack;

import org.junit.Test;

/**
 * 目标和 有几种方式可以得到目标和
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
        //怎么计算的？
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

    public int findTargetSumWays1(int[] nums, int s) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+s];
    }

    /**
     * 测试
     */
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        int targetSumWays = findTargetSumWays(nums, 3);
        System.out.println(targetSumWays);
    }

    /**
     * 测试
     */
    @Test
    public void test1() {
        int[] nums = {1, 1, 1, 1, 1};
        int targetSumWays = findTargetSumWays1(nums, 3);
        System.out.println(targetSumWays);
    }

    /**
     * 测试位运算
     */
    @Test
    public void test2(){
        System.out.println(15>>>1);
    }
}
