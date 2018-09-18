package Learn.ArrayAndString;

import org.junit.Test;

/**
 * 返回有序数组中目标和的索引， index1 < index2
 *
 * @author zhongtao on 2018/9/18
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int height = numbers.length - 1;
        while (numbers[low] + numbers[height] != target) {
            if (numbers[low] + numbers[height] < target) {
                low++;
            } else {
                height--;
            }
        }
        return new int[]{low + 1, height + 1};
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        int[] numbers = {2, 7, 11, 15};
        int target = 13;
        int[] ints = twoSum(numbers, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
