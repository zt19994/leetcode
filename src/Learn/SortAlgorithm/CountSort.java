package Learn.SortAlgorithm;

import org.junit.Test;

/**
 * 计数排序
 *
 * @author zhongtao on 2018/12/26
 */
public class CountSort {

    /**
     * 计数排序
     */
    public void countSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组中的最大最小值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int temp[] = new int[max];

        //找出每个数字出现的次数
        for (int i = 0; i < arr.length; i++) {
            //每个元素在temp中的位置 position = arr[i] - min
            int position = arr[i] - min;
            temp[position]++;
        }

        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            //temp[i] 大于0 表示有重复元素
            while (temp[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }


    /**
     * 测试计数排序
     */
    @Test
    public void testCountSort() {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        countSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
