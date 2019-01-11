package Learn.BinarySearch;

import java.util.Arrays;

/**
 * 求第k小对的距离
 *
 * @author zt1994 2019/1/11 10:26
 */
public class FindKSmallestPairDistance {

    /**
     * 第k对最小绝对差
     */
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        // 最小绝对差
        int low = nums[1] - nums[0];
        for (int i = 1; i < n - 1; i++) {
            low = Math.min(low, nums[i + 1] - nums[i]);
        }

        // 最大绝对差
        int high = nums[n - 1] - nums[0];

        // 二分查找第k个绝对差
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(nums, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // 返回绝对差小于或等于mid的对数。
    private int countPairs(int[] nums, int mid) {
        int n = nums.length, res = 0;
        for (int i = 0; i < n; ++i) {
            int j = i;
            while (j < n && nums[j] - nums[i] <= mid) {
                j++;
            }
            res += j - i - 1;
        }
        return res;
    }
}
