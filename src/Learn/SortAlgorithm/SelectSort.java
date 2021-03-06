package Learn.SortAlgorithm;

import org.junit.Test;

/**
 * 选择排序
 * 1. 简单选择排序
 * 2. 堆排序
 *
 * @author zhongtao on 2018/12/20
 */
public class SelectSort {

    /**
     * 简单选择排序
     * <p>
     * 简单选择排序的算法思路：
     * 1. 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 2. 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
     * 3. 以此类推，直到所有元素均排序完毕。
     */
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 找到当前循环最小值索引
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            // 交换当前循环起点值和最小值索引位置的值
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


    /**
     * 堆排序
     * <p>
     * 堆排序的算法思路：
     * 1. 最大堆调整（Max Heapify）：将堆的末端子节点作调整，某个节点的值最多和其父节点的值一样大；
     * 2. 创建最大堆（Build Max Heap）：将堆中的所有数据重新排序,堆中的最大元素存放在根节点中；
     * 3. 堆排序（HeapSort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算。
     */
    public void heapSort(int[] arr) {
        buildMaxHeap(arr);

        //进行n-1次循环，完成排序
        for (int i = arr.length - 1; i > 0; i--) {
            //最后一个元素和第一个元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // 筛选 R[0] 结点，得到i-1个结点的堆 将arr中前i-1个记录重新调整为大顶堆
            heapAdjust(arr, 0, i);
        }
    }


    /**
     * 构建大顶堆
     * <p>
     * 将数组中最大的值放在根节点
     */
    private void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length - 1);
        }
    }

    /**
     * 堆调整
     * <p>
     * 将数组中最大的值放在根节点
     *
     * @param arr    待排序数组
     * @param parent 父节点索引
     * @param length 数组长度
     */
    private void heapAdjust(int[] arr, int parent, int length) {
        int temp = arr[parent]; //temp保存当前父节点
        int child = 2 * parent + 1; //获取左子节点

        while (child < length) {
            // 如果有右子结点，并且右子结点的值大于左子结点的值，则选取右子结点的值
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                child++;
            }
            // 如果父结点的值已经大于子结点的值，则直接结束
            if (temp >= arr[child]) {
                break;
            }
            // 把子结点的值赋给父结点
            arr[parent] = arr[child];
            // 选取子结点的左子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }
        arr[parent] = temp;
    }


    /**
     * 测试选择排序
     */
    @Test
    public void testSelectSort() {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        selectSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * 测试堆排序
     */
    @Test
    public void testHeapSort() {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        heapSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
