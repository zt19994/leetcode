package Learn.HashTable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four lists A, B, C, D of integer values,
 * compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * <p>
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -2的28次方 to 2的28次方 - 1 and the result is guaranteed to be at most 2的31次方 - 1.
 *
 * @author zhongtao on 2018/11/19
 */
public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                //map.put(sum, map.getOrDefault(sum, 0) + 1);
                map.put(sum, map.get(sum) != null ? map.get(sum) + 1 : 1);
            }
        }

        int res = 0;
        for (int a : A) {
            for (int b : B) {
                //res += map.getOrDefault(-1 * (a + b), 0);
                res += map.get(-1 * (a + b)) != null ? map.get(-1 * (a + b)) : 0;
            }
        }
        return res;
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        System.out.println(fourSumCount(A, B, C, D));
    }
}
