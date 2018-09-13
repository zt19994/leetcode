package Learn.queue;

import org.junit.Test;

import java.util.*;

/**
 * Perfect Squares 完全平方数
 *
 * @author zhongtao on 2018/8/29
 */
public class PerfectSquares {


    /**
     * BFS
     */
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int step = 0;
        queue.offer(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (!set.add(curr)) continue;
                for (int j = 1; j <= Math.sqrt(curr); j++) {
                    int next = curr - j * j;
                    if (next == 0) return step;
                    queue.offer(next);
                }
            }
        }
        return 0;
    }

    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }


    /**
     * 原理是什么？
     */
    public int numSquares2(int n) {
        if (n == 1) return 1;
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }

        for (int a = 0; a * a <= n; a++) {
            double b = Math.sqrt(n - a * a);
            if (b != Math.floor(b)) continue;
            int intB = (int) b;
            if (a * a + intB * intB == n) {
                if (a == 0) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 3;
    }

    /**
     * 测试
     */
    @Test
    public void test1() {
        System.out.println(numSquares2(20));
        System.out.println(Math.floor(8.9));
    }
}
