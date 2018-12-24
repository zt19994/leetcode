package Learn.SortAlgorithm;

import org.junit.Test;

/**
 * 交换排序
 * 1. 冒泡排序
 * 2. 快速排序
 *
 * @author zhongtao on 2018/12/24
 */
public class SwapSort {

    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // temp 临时存储 arr[j] 的值
                    int temp = arr[j];
                    //交换 arr[j] 和 arr[j+1] 的值
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numbers 待排序数组
     * @param low     开始位置
     * @param high    结束位置
     * @return 中轴所在位置
     */
    private int getMiddle(int[] numbers, int low, int high) {
        int temp = numbers[low]; //数组的第一个作为中轴
        while (low < high) {
            while (low < high && numbers[high] >= temp) {
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while (low < high && numbers[low] < temp) {
                low++;
            }
            numbers[high] = numbers[low]; //比中轴大的记录移到高端
        }
        numbers[low] = temp; //中轴记录到尾
        return low; // 返回中轴的位置
    }

    /**
     * @param numbers 待排序数组
     * @param low     开始位置
     * @param high    结束位置
     */
    private void quickSort(int[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high); //将numbers数组进行一分为二
            quickSort(numbers, low, middle - 1);  //对低字段表进行递归排序
            quickSort(numbers, middle + 1, high); //对高字段表进行递归排序
        }
    }

    /**
     * 快速排序
     *
     * @param numbers 待排序数组
     */
    public void quick(int[] numbers) {
        //查看数组是否为空
        if (numbers.length > 0) {
            quickSort(numbers, 0, numbers.length - 1);
        }
    }


    /**
     * 测试冒泡排序
     */
    @Test
    public void testBubbleSort() {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        bubbleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    /**
     * 测试快速排序
     */
    @Test
    public void testQuickSort() {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        quick(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
