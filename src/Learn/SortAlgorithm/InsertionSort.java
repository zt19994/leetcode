package Learn.SortAlgorithm;

/**
 * 插入排序
 * 1。直接插入排序
 * 2.希尔排序
 *
 * @author zhongtao on 2018/12/18
 */
public class InsertionSort {

    /**
     * 直接排序
     */
    public void straightLnsertionSort(double[] sorted) {
        int sortedLen = sorted.length;
        for (int j = 2; j < sortedLen; j++) {
            if (sorted[j] < sorted[j - 1]) {
                sorted[0] = sorted[j]; //保存一下
                sorted[j] = sorted[j - 1]; //前面元素后移
                int insertPos = 0;
                for (int k = j - 2; k >= 0; k--) {
                    if (sorted[k] > sorted[0]) {
                        sorted[k + 1] = sorted[k];
                    } else {
                        insertPos = k + 1;
                        break;
                    }
                }
                sorted[insertPos] = sorted[0];
            }
        }
    }

    //直接插入排序
    public static void insertSort(int[] arr) {
        //外层循环确定待比较数值
        for (int i = 1; i < arr.length; i++) {  //必须i=1，因为开始从第二个数与第一个数进行比较
            int temp = arr[i];  //待比较数值
            int j = i - 1;
            //内层循环为待比较数值确定其最终位置
            for (; j >= 0 && arr[j] > temp; j--) {  //待比较数值比前一位置小，应插往前插一位
                //将大于temp的值整体后移一个单位
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp; //待比较数值比前一位置大，最终位置无误
        }
    }


    /**
     * 希尔排序
     */
    public void shellInsertionSort(int[] arr) {
        //dk是步长
        int dk = arr.length;
        while (dk != 1) {
            //刚开始选择长度的一半作为步长，每次减少一半
            dk = dk / 2;
            //k是每个子序列的第一个元素的下标
            for (int k = 0; k <= dk; k++) {
                //通过改变i来改变倍数，确定下标
                for (int i = 1; k + i * dk < arr.length; i++) {
                    //j是子序列中，小于i的所有下标
                    for (int j = 0; j < i; j++) {
                        //子序列进行插入排序
                        if (arr[k + j * dk] > arr[k + i * dk]) {
                            int tmp = arr[k + i * dk];
                            for (int p = i; p > j; p--) {
                                arr[k + p * dk] = arr[k + (p - 1) * dk];
                            }
                            arr[k + j * dk] = tmp;
                        }
                    }
                }
            }
        }
    }

}
