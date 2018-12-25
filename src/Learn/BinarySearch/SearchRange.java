package Learn.BinarySearch;

import org.junit.Test;

/**
 * 给定一个按升序排序的整数数组，查找给定目标值的起始和结束位置。
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * @author zhongtao on 2018/12/21
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = searchEqualOrGreater(nums, target);
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }
        int left_1 = searchEqualOrGreater(nums, target + 1);
        int right = -1;
        if (nums[left_1] >= target + 1) {
            right = left_1 - 1;
        } else {
            right = left_1;
        }
        return new int[]{left, right};
    }

    public int searchEqualOrGreater(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            //mid is always biased towards left
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                //we want to move hi to the left
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 测试搜索范围
     */
    @Test
    public void testSearchRange() {
        int[] nums = {5,7,7,8,8,10};
        int[] ints = searchRange(nums, 8);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
