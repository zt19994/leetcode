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
     */
    public void selectSort(int[] arr) {
        int minIndex = 0;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 找到当前循环最小值索引
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            // 交换当前循环起点值和最小值索引位置的值
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


    /**
     * 堆排序
     */
    public void heapSort(int[] arr) {
        //循环建立初始堆
        for (int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length - 1);
        }

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
     * 堆调整
     *
     * @param arr    待排序数组
     * @param parent 父节点
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


    public void buildMInHeap(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = (i - 1) / 2; j >= 0; j--) {
                //i是奇数，存在一个节点只有一个叶子节点
                if ((2 * j + 1 == i) && (i % 2 != 0)) {
                    if (arr[j] < arr[2 * j + 1]) {
                        swap(arr, j, 2 * j + 1);
                    }
                } else {
                    if (arr[j] < arr[2 * j + 1]) {
                        swap(arr, j, 2 * j + 1);
                    }
                    if (arr[j] < arr[2 * j + 2]) {
                        swap(arr, j, 2 * j + 2);
                    }
                }
            }
            swap(arr, 0, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
