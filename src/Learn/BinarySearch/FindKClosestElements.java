package Learn.BinarySearch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到K个最近的元素
 * <p>
 * 给定一个排序的数组，两个整数k和x，找出数组中离x最近的k个元素。结果也应该按升序排序。如果有平局，较小的元素总是首选。
 * <p>
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * <p>
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 *
 * @author zhongtao on 2018/12/29
 */
public class FindKClosestElements {

    /**
     * 找到K个最近的元素
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findKClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(arr[left + i]);
        }
        return res;
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        List<Integer> elements = findKClosestElements(nums, 4, -1);
        for (Integer element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
