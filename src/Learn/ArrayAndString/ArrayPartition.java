package Learn.ArrayAndString;

import org.junit.Test;

import java.util.Arrays;

/**
 * 数组划分
 *
 * @author zhongtao on 2018/9/18
 */
public class ArrayPartition {

    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }


    /**
     * 测试数组划分
     */
    @Test
    public void test(){
       int[] nums = {1, 2, 3, 4};
        int i = arrayPairSum(nums);
        System.out.println(i);
    }
}
