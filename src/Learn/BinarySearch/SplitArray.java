package Learn.BinarySearch;

/**
 * 分割数组
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * Output:
 * 18
 * Explanation:
 * There are four ways to split nums into two subarrays.The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 *
 * @author zt1994 2019/1/14 14:56
 */
public class SplitArray {

    /**
     * 分割数组
     */
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        return (int) binary(nums, m, sum, max);
    }

    private long binary(int[] nums, int m, long high, long low) {
        long mid = 0;
        while (low < high) {
            mid = (high + low) / 2;
            if (valid(nums, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private boolean valid(int[] nums, int m, long max) {
        int cur = 0;
        int count = 1;
        for (int num : nums) {
            cur += num;
            if (cur > max) {
                cur = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
