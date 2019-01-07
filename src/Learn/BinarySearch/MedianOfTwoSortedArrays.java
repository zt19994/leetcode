package Learn.BinarySearch;

import org.junit.Test;

/**
 * 两个排序数组的中值
 * <p>
 * 分别有大小为m和n的两个排序数组nums1和nums2。
 * 求两个排序数组的中值。总的运行时复杂性应该是O(log (m+n))。
 * 您可以假设nums1和nums2不能同时为空。
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 *
 * @author zhongtao on 2019/1/5
 */
public class MedianOfTwoSortedArrays {

    /**
     * 两个排序数组的中值
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (getMid(A, 0, B, 0, left) + getMid(A, 0, B, 0, right)) / 2.0;
    }

    /**
     * 获取中间值
     *
     * @param A
     * @param aStart
     * @param B
     * @param bStart
     * @param k
     * @return
     */
    public double getMid(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) {
            return B[bStart + k - 1];
        }
        if (bStart > B.length - 1) {
            return A[aStart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }
        int aMid = Integer.MAX_VALUE;
        int bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < A.length) {
            aMid = A[aStart + k / 2 - 1];
        }
        if (bStart + k / 2 - 1 < B.length) {
            bMid = B[bStart + k / 2 - 1];
        }

        if (aMid < bMid) {
            return getMid(A, aStart + k / 2, B, bStart, k - k / 2);// Check: aRight + bLeft
        } else {
            return getMid(A, aStart, B, bStart + k / 2, k - k / 2);// Check: bRight + aLeft
        }
    }


    /**
     * 合并两个数组，再进行计算
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] mergedArrays = merge(nums1, nums2);

        int mid = mergedArrays.length / 2;

        if (mergedArrays.length % 2 == 0) {
            double left = (double) mergedArrays[mid - 1];
            double right = (double) mergedArrays[mid];
            return (left + right) / 2.0;
        } else {
            return mergedArrays[mid];
        }

    }

    /**
     * 合并数组
     */
    private static int[] merge(int[] sorted1, int[] sorted2) {
        int c1 = 0;
        int c2 = 0;
        int index = 0;
        int sum = sorted1.length + sorted2.length;
        int[] merged = new int[sum];
        while (c1 < sorted1.length && c2 < sorted2.length) {
            if (sorted1[c1] <= sorted2[c2]) {
                merged[index++] = sorted1[c1++];
            } else {
                merged[index++] = sorted2[c2++];
            }
        }
        while (c1 < sorted1.length) {
            merged[index++] = sorted1[c1++];
        }
        while (c2 < sorted2.length) {
            merged[index++] = sorted2[c2++];
        }
        return merged;
    }

    /**
     * 测试
     */
    @Test
    public void test() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays1(nums1, nums2));
    }
}
