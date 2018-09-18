package Learn.BinarySearch;

import org.junit.Test;

/**
 * 二分法
 *
 * @author zhongtao on 2018/8/27
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int current = nums[mid];
            if (current==target){
                return mid;
            }else if (current > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }


    /**
     * 测试二分法
     */
    @Test
    public void test() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 1));
        System.out.println(5/2);
    }
}
