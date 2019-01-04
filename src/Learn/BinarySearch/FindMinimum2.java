package Learn.BinarySearch;

import org.junit.Test;

/**
 * 在旋转排序数组中求最小值，数组可能包含重复项。
 * <p>
 * Input: [1,3,5]
 * Output: 1
 * <p>
 * Input: [2,2,2,0,1]
 * Output: 0
 *
 * @author zhongtao on 2019/1/4
 */
public class FindMinimum2 {

    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                if (nums[lo] < nums[hi]) {
                    return nums[lo];
                } else {
                    hi--;
                }
            }
        }
        return nums[lo];
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums1 = {2, 2, 2, 0, 1};
        System.out.println(findMin(nums));
        System.out.println(findMin(nums1));
    }
}
