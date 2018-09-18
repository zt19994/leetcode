package Learn.ArrayAndString;

import org.junit.Test;

/**
 * 寻找数组的轴心 即左边和右边和一样
 * <p>
 * 给定一组整数nums，写一个返回该数组的“轴心”索引的方法。
 * 我们把主索引定义为索引左边的数字之和等于索引右边的数字之和。
 * 如果没有这样的索引，我们应该返回-1。如果有多个主索引，您应该返回最左边的枢轴索引。
 *
 * @author zhongtao on 2018/8/22
 */
public class PivotIndex {

    /**
     * 分别求出左右两边之和，比较是否相等
     */
    public int pivotIndex1(int[] nums) {
        int size = nums.length;
        if (size < 1) {
            return -1;
        }
        int resultIndex = -1;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < size; i++) {
            leftSum = 0;
            rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for (int k = i + 1; k < size; k++) {
                rightSum += nums[k];
            }
            if (leftSum == rightSum) {
                resultIndex = i;
                break;
            }
        }
        return resultIndex;
    }


    /**
     * 先计算总和
     * 然后总和减去左边之和左边和，即有轴心
     * @param nums
     * @return
     */
    public int pivotIndex2(int[] nums) {
        int allSum = 0;
        for (int num : nums) {
            allSum += num;
        }
        int size = nums.length;
        int leftSum = 0;
        for (int i = 0; i < size; i++) {
            if (leftSum == allSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    /**
     * 测试
     */
    @Test
    public void test() {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int i = pivotIndex1(nums);
        int i1 = pivotIndex2(nums);
        System.out.println(i + "   " + i1);
    }
}
