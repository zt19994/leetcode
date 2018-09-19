package Learn.ArrayAndString;

import org.junit.Test;

/**
 * 旋转数组
 *
 * @author zhongtao on 2018/9/19
 */
public class RotateArray {
    /**
     * leetcode上测试有问题，应该是不能新建数组
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length - k;
        int[] newNums = new int[nums.length];
        for (int i = 0; i < k; i++) {
            newNums[i] = nums[len + i];
        }
        for (int i = 0; i < len; i++) {
            newNums[k + i] = nums[i];
        }
    }

    public void rotate1(int[] nums, int k) {

        if (nums == null || nums.length < 2) {
            return;
        }

        k = k % nums.length;
        //反向前半段数组
        reverse(nums, 0, nums.length - k - 1);
        //反向后半段数组
        reverse(nums, nums.length - k, nums.length - 1);
        //整个数组都反向
        reverse(nums, 0, nums.length - 1);

    }

    /**
     * 反向数组
     */
    private void reverse(int[] nums, int i, int j) {
        int tmp = 0;
        while (i < j) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    /**
     * 测试反向数组
     */
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 2);

        System.out.println(4 % 7);
    }
}
