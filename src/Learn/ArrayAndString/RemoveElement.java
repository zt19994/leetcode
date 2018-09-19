package Learn.ArrayAndString;

import org.junit.Test;

/**
 * 移除元素
 *
 * @author zhongtao on 2018/9/19
 */
public class RemoveElement {

    /**
     * 使用两个指针来移除元素
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }


    public int removeElement1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 2, 4, 5};
        System.out.println(removeElement(nums, 2));
    }

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 2, 4, 5};
        System.out.println(removeElement1(nums, 2));
    }
}
