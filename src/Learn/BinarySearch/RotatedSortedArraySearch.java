package Learn.BinarySearch;

import org.junit.Test;

/**
 * 在旋转排序数组中搜索
 *
 * @author zhongtao on 2018/12/17
 */
public class RotatedSortedArraySearch {

    public int search(int[] nums, int target) {
        int low = 0;
        int hight = nums.length - 1;
        while (low < hight) {
            int mid = low + (hight - low) / 2;
            int num = nums[mid];
            // nums[mid] 和 target 在同一段
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                num = nums[mid];
            } else {
                //nums [ mid ] 和 target 不在同一段，同时还要考虑下变成 -inf 还是 inf。
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (num < target) {
                low = mid + 1;
            } else if (num > target) {
                hight = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * 测试
     */
    @Test
    public void test() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(search(nums, 1));
    }
}
