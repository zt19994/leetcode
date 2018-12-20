package Learn.SortAlgorithm;

/**
 * 冒泡排序
 *
 * @author zhongtao on 2018/12/20
 */
public class BubbleSort {

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
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
}
