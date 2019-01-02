package Learn.BinarySearch;

import org.junit.Test;

/**
 * 有效的完全平方
 *
 * @author zhongtao on 2019/1/2
 */
public class ValidPerfectSquare {

    /**
     * 判断是否是完全平方
     */
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sqrt = num / mid;
            if (sqrt < mid) {
                right = mid - 1;
            } else if (sqrt > mid) {
                left = mid + 1;
            } else {
                return mid * mid == num;
            }
        }
        return right * right == num;
    }


    /**
     * 测试
     */
    @Test
    public void test(){
        System.out.println(isPerfectSquare(5));
    }
}
