package Learn.QueueAndStack;

import org.junit.Test;

/**
 * 斐波纳契数
 *
 * @author zt1994 2019/2/17 16:54
 */
public class FibonacciNumber {

    /**
     * 斐波那契数列，通常表示为F(n)，形成一个序列，称为斐波那契数列，使每个数字是从0和1开始的前两个数字的和。也就是说
     * <p>
     * Input: 2
     * Output: 1
     * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
     */
    public int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }

    /**
    * 测试
    */
    @Test
    public void testFib(){
        System.out.println(fib(4));
    }
}
