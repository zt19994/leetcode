package Learn.HashTable;

import org.junit.Test;

import java.util.*;

/**
 * 两个数组的交集
 *
 * @author zhongtao on 2018/10/8
 */
public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }

        return r;
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pnt1 = 0;
        int pnt2 = 0;
        ArrayList<Integer> myList = new ArrayList<Integer>();
        while ((pnt1 < nums1.length) && (pnt2 < nums2.length)) {
            if (nums1[pnt1] < nums2[pnt2]) {
                pnt1++;
            } else {
                if (nums1[pnt1] > nums2[pnt2]) {
                    pnt2++;
                } else {
                    myList.add(nums1[pnt1]);
                    pnt1++;
                    pnt2++;
                }
            }
        }
        int[] res = new int[myList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = (Integer) myList.get(i);
        }
        return res;
    }


    /**
     * 测试
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     */
    @Test
    public void test() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersect = intersect1(nums1, nums2);
        for (int i : intersect) {
            System.out.println(i);
        }
    }
}
