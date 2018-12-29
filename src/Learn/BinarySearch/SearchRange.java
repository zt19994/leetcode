package Learn.BinarySearch;

import org.junit.Test;

/**
 * 给定一个按升序排序的整数数组，查找给定目标值的起始和结束位置。
 * 算法的运行时复杂度必须是O(log n)的顺序。
 * 如果在数组中没有找到目标，返回[-1，-1]。
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

    /**
     * 搜索范围
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = searchEqualOrGreater(nums, target);
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }
        int left1 = searchEqualOrGreater(nums, target + 1);
        int right;
        if (nums[left1] >= target + 1) {
            right = left1 - 1;
        } else {
            right = left1;
        }
        return new int[]{left, right};
    }

    /**
     * 搜索大于或者等于目标值
     */
    public int searchEqualOrGreater(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            //mid 总是偏向左边
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                //将hi移动到左边
                high = mid;
            }
        }
        return low;
    }

    /**
     * 测试搜索范围
     */
    @Test
    public void testSearchRange() {
        int[] nums = {5, 7, 7, 8, 8, 8, 8, 10};
        int[] ints = searchRange(nums, 8);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
    }
}
