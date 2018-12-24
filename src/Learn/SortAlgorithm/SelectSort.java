package Learn.SortAlgorithm;

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
}
