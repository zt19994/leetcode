package Learn.array;

import org.junit.Test;

/**
 * 最多的至少是其他的两倍
 * 在一个给定的整数数组nums中，总是有一个最大的元素。
 * 找出数组中最大的元素是否至少是数组中其他数字的两倍。
 * 如果是，返回最大元素的索引，否则返回-1。
 *
 * @author zhongtao on 2018/8/22
 */
public class DominantIndex {

    /**
     * 找到最大值和第二大值
     * 比较最大值是否是第二大值的两倍
     */
    public int dominantIndex(int[] nums) {
        int top1 = 0;
        int top1Index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > top1) {
                top1 = nums[i];
                top1Index = i;
            }
        }

        //将数组中最大值设为0，寻找第二大值
        nums[top1Index] = 0;
        int top2 = 0;
        for (int num : nums) {
            if (num > top2) {
                top2 = num;
            }
        }

        if (top2 * 2 > top1) {
            return -1;
        }
        return top1Index;
    }


    /**
     * 先找到最大值索引
     * 在循环遍历比较最大值和当前值是否大两倍
     */
    public int dominantIndex2(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }


    /**
     * 测试
     */
    @Test
    public void test(){
        int[] nums = {1, 13, 3, 6, 5, 6};
        int index = dominantIndex(nums);
        System.out.println(index);
    }
}
