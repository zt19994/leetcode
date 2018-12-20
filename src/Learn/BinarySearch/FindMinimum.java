package Learn.BinarySearch;

import org.junit.Test;

/**
 * 在旋转排序数组中求最小值
 * <p>
 * Input: [3,4,5,1,2]
 * Output: 1
 * <p>
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 *
 * @author zhongtao on 2018/12/20
 */
public class FindMinimum {

    public int findMin(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return nums[0];
        }

        int left = 0;
        int right = N - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }


    /**
     * 测试
     */
    @Test
    public void test(){
        int[] nums = {4,5,6,7,0,1,2};

        int min = findMin(nums);
        System.out.println(min);
    }
}
