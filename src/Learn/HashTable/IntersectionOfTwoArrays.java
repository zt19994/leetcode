package Learn.HashTable;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个数字的交集
 *
 * @author zhongtao on 2018/9/26
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }


    /**
     * 测试
     */
    @Test
    public void test(){
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 3};
        int[] intersection = intersection(nums1, nums2);
        for (int i : intersection) {
            System.out.println(i);
        }
    }
}
