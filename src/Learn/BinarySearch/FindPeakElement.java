package Learn.BinarySearch;

import org.junit.Test;

/**
 * 寻找波峰
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * <p>
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 *
 * @author zhongtao on 2018/12/19
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return 0;
        }

        int left = 0;
        int right = N - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (left == N - 1 || nums[left] > nums[left + 1]) ? left : right;
    }


    /**
     * 测试
     */
    @Test
    public void test(){
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }
}
