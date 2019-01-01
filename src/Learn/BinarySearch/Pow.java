package Learn.BinarySearch;

import org.junit.Test;

/**
 * 实现pow(x, n)，它计算出x的n次方。
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 *
 * @author zhongtao on 2019/1/1
 */
public class Pow {

    public double myPow(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long) n);
        while (absN > 0) {
            if ((absN & 1) == 1) {
                ans *= x;
            }
            absN >>= 1;
            x *= x;
        }
        return n < 0 ? 1 / ans : ans;
    }

    public double pow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                return x == 1 || x == -1 ? 1 : 0;
            }
        }
        return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
    }

    /**
     * 测试
     */
    @Test
    public void testPow() {
        System.out.println(myPow(2.0, 4));
        System.out.println(pow(2.0, 4));
    }
}
