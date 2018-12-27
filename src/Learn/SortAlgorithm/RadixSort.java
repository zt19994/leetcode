package Learn.SortAlgorithm;

import org.junit.Test;

/**
 * 基数排序
 *
 * @author zhongtao on 2018/12/26
 */
public class RadixSort {

    /**
     * 基数排序
     *
     * @param arr 待排序数组
     */
    public void radixSort(int[] arr) {
        int max = getMax(arr);  // 数组arr中的最大值

        for (int exp = 1; max / exp > 0; exp *= 10)
            //从个位开始，对数组arr按"exp指数"进行排序
            countSort(arr, exp);
    }

    /**
     * 获取数组中最大值
     */
    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 对数组按照"某个位数"进行排序(计数排序)
     * <p>
     * 例如:
     * 1、当exp=1 表示按照"个位"对数组进行排序
     * 2、当exp=10 表示按照"十位"对数组进行排序
     *
     * @param arr 待排序数组
     * @param exp 指数 对数组arr按照该指数进行排序
     */
    private void countSort(int[] arr, int exp) {
        int[] temp = new int[arr.length]; // 存储"被排序数据"的临时数组
        int[] buckets = new int[10];

        // 将数据出现的次数存储在buckets[]中
        for (int i = 0; i < arr.length; i++) {
            buckets[(arr[i] / exp) % 10]++;
        }

        // 更改buckets[i] 目的是让更改后的buckets[i]的值，是该数据在temp[]中的位置。
        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }

        // 将数据存储到临时数组temp[]中
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
            buckets[(arr[i] / exp) % 10]--;
        }

        // 将排序好的数据赋值给arr[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }


    /**
     * 测试基数排序
     */
    @Test
    public void testRadixSort() {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        radixSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
