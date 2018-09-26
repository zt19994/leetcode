package Learn.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Happy number
 *
 * @author zhongtao on 2018/9/26
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        if (n == 0) {
            return false;
        } else if (n == 1) {
            return true;
        }

        Set<Integer> hashSet = new HashSet<>();
        int sum = 0;
        while (true) {
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (sum == 1) {
                return true;
            } else {
                if (hashSet.contains(sum)) {
                    return false;
                } else {
                    hashSet.add(sum);
                }
            }
            n = sum;
            sum = 0;
        }
    }


    public boolean isHappy1(int n) {
        if (n <= 0) return false;
        while (n >= 10) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return n == 1 || n == 7;
    }
}
