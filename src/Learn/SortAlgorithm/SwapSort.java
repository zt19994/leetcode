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
     * <p>
     * 冒泡排序算法的算法思路：
     * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2. 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 3. 针对所有的元素重复以上的步骤，除了最后一个。
     * 4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
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
     * 快速排序
     * <p>
     * 快速排序的算法思路：（分治法）
     * 1. 先从数列中取出一个数作为中间值middle；
     * 2. 将比这个数小的数全部放在它的左边，**大于或等于**它的数全部放在它的右边；
     * 3. 对左右两个小数列重复第二步，直至各区间只有1个数。
     *
     * @param arr 待排序数组
     */
    public void quickSort(int[] arr) {
        //查看数组是否为空
        if (arr.length > 0) {
            sort(arr, 0, arr.length - 1);
        }
    }

    /**
     * @param arr  待排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = getMiddle(arr, low, high); //将numbers数组进行一分为二
            sort(arr, low, mid - 1);  //对低字段表进行递归排序
            sort(arr, mid + 1, high); //对高字段表进行递归排序
        }
    }

    /**
     * 查找出中轴（默认是最低位low）的在arr数组排序后所在位置
     *
     * @param arr  待排序数组
     * @param low  开始位置
     * @param high 结束位置
     * @return 中轴所在位置
     */
    private int getMiddle(int[] arr, int low, int high) {
        int temp = arr[low]; //数组的第一个作为中轴
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];//比中轴小的记录移到低端
            while (low < high && arr[low] < temp) {
                low++;
            }
            arr[high] = arr[low]; //比中轴大的记录移到高端
        }
        arr[low] = temp; //中轴记录到尾
        return low; // 返回中轴的位置
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
        quickSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
