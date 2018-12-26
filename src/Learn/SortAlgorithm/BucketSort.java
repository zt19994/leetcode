package Learn.SortAlgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 桶排序
 *
 * @author zhongtao on 2018/12/26
 */
public class BucketSort {

    /**
     * 桶排序
     *
     * @param arr 待排序数组
     */
    public static void bucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }

        //将每个元素放入桶
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / arr.length;
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucketArr.get(i));
        }

        int position = 0;
        //合并桶
        for (int i = 0; i < bucketNum; i++) {
            for (int j = 0; j < bucketArr.get(i).size(); j++) {
                arr[position++] = bucketArr.get(i).get(j);
            }
        }
    }


    /**
     * 测试桶排序
     */
    @Test
    public void testBucketSort() {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        bucketSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
