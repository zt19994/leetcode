package Learn.SortAlgorithm;


import org.junit.Test;

/**
 * 插入排序
 * 1.直接插入排序
 * 2.希尔排序
 *
 * @author zhongtao on 2018/12/18
 */
public class InsertionSort {

    /**
     * 直接插入排序
     * <p>
     * 直接插入排序的算法思路：
     * 1. 设置监视哨temp，将待插入记录的值赋值给temp；
     * 2. 设置开始查找的位置j；
     * 3. 在数组arr中进行搜索，搜索中将第j个记录后移，直至temp≥arr[j]为止；
     * 4. 将temp插入arr[j+1]的位置上。
     */
    public void insertSort(int[] arr) {
        //外层循环确定待比较数值
        //必须i=1，因为开始从第二个数与第一个数进行比较
        for (int i = 1; i < arr.length; i++) {
            //待比较数值
            int temp = arr[i];
            int j = i - 1;
            //内层循环为待比较数值确定其最终位置
            //待比较数值比前一位置小，应插往前插一位
            for (; j >= 0 && arr[j] > temp; j--) {
                //将大于temp的值整体后移一个单位
                arr[j + 1] = arr[j];
            }
            //待比较数值比前一位置大，最终位置无误
            arr[j + 1] = temp;
        }
    }


    /**
     * 希尔排序
     * <p>
     * 按下标的一定增量分组然后进行插入排序
     */
    public void shellSort(int[] arr) {
        int d = arr.length;
        while (d >= 1) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                //按下标的一定增量分组然后进行插入排序
                for (int i = x + d; i < arr.length; i = i + d) {
                    int temp = arr[i];
                    int j;
                    for (j = i - d; j >= 0 && arr[j] > temp; j = j - d) {
                        //移动下标
                        arr[j + d] = arr[j];
                    }
                    arr[j + d] = temp;
                }
            }
        }
    }

    //希尔排序
    public void shellSort2(int[] arr) {
        //d是步长
        int d = arr.length;
        while (d > 1) {
            //刚开始选择长度的一半作为步长，每次减少一半
            d = d / 2;
            //x是每个子序列的第一个元素的下标
            for (int x = 0; x <= d; x++) {
                //通过改变i来改变倍数，确定下标
                for (int i = 1; x + i * d < arr.length; i++) {
                    //j是子序列中，小于i的所有下标
                    for (int j = 0; j < i; j++) {
                        //子序列进行插入排序
                        if (arr[x + j * d] > arr[x + i * d]) {
                            int tmp = arr[x + i * d];
                            for (int p = i; p > j; p--) {
                                arr[x + p * d] = arr[x + (p - 1) * d];
                            }
                            arr[x + j * d] = tmp;
                        }
                    }
                }
            }
        }
    }


    /**
     * 测试直接插入排序
     */
    @Test
    public void testInsertSort() {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        insertSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    /**
     * 测试希尔排序
     */
    @Test
    public void testShellSort() {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        shellSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
