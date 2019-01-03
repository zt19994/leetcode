package Learn.SortAlgorithm;

import org.junit.Test;

/**
 * 归并排序
 *
 * @author zhongtao on 2018/12/25
 */
public class MergeSort {

    /**
     * 二路归并排序
     * <p>
     * 二路归并排序的算法思路：
     * 1. 将数组分成A，B 两个数组，如果这2个数组都是有序的，那么就可以很方便的将这2个数组进行排序。
     * 2. 让这2个数组有序，可以将A，B组各自再分成2个数组。依次类推，当分出来的数组只有1个数据时，可以认为数组已经达到了有序。
     * 3. 然后再合并相邻的2个数组。这样通过先递归的分解数组，再合并数组就完成了归并排序。
     */
    public void mergeSort(int[] arr) {
        int[] temp = new int[arr.length]; //临时数组
        sort(arr, temp, 0, arr.length - 1);
    }

    /**
     * @param arr   待排序数组
     * @param left  开始位置
     * @param right 结束位置
     */
    private void sort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, temp, left, mid);
            sort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    /**
     * 将两个有序表归并成一个有序表
     *
     * @param arr       待排序数组
     * @param temp      临时数组
     * @param leftStart 左边开始下标
     * @param leftEnd   左边结束下标(mid)
     * @param rightEnd  右边结束下标
     */
    private static void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightEnd) {
        int rightStart = leftEnd + 1;
        int tempIndex = leftStart; // 从左边开始算
        int len = rightEnd - leftStart + 1; // 元素个数
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart] <= arr[rightStart]) {
                temp[tempIndex++] = arr[leftStart++];
            } else {
                temp[tempIndex++] = arr[rightStart++];
            }
        }
        // 左边如果有剩余 将左边剩余的归并
        while (leftStart <= leftEnd) {
            temp[tempIndex++] = arr[leftStart++];
        }
        // 右边如果有剩余 将右边剩余的归并
        while (rightStart <= rightEnd) {
            temp[tempIndex++] = arr[rightStart++];
        }
        // 从临时数组拷贝到原数组
        for (int i = 0; i < len; i++) {
            arr[rightEnd] = temp[rightEnd];
            rightEnd--;
        }
    }


    /**
     * 测试二路归并排序
     */
    @Test
    public void testMergeSort() {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        mergeSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
