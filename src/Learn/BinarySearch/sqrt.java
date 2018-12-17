package Learn.BinarySearch;

import org.junit.Test;

/**
 * 开平方 二分法
 *
 * @author zhongtao on 2018/8/27
 */
public class sqrt {

    public int sqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sqrt = x / mid;
            if (sqrt < mid) {
                right = mid - 1;
            } else if (sqrt > mid) {
                left = mid + 1;
            } else { // sqrt == mid
                return mid;
            }
        }
        return right;
    }


    /**
     * 测试
     */
    @Test
    public void testSqrt(){
        int sqrt = sqrt(8);
        System.out.println(sqrt);
    }
}
