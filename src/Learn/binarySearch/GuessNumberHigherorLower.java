package Learn.binarySearch;

/**
 * @author zhongtao on 2018/8/27
 */
public class GuessNumberHigherorLower {
    public int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int guessResult = guess(mid);
            if (guessResult == 0) {
                return mid;
            } else if (guessResult == 1) {
                right = mid + 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int guessNumber1(int n) {
        int i = 1, j = n;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}
