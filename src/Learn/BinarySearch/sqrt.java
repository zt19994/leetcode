package Learn.BinarySearch;

/**
 * @author zhongtao on 2018/8/27
 */
public class sqrt {

    public int sqrt(int x){
        if(x == 0 || x == 1) return x;
        int left = 0;
        int right = x;
        while(left <= right) {
            int mid = (left+right)/2;
            int sqrt = x/mid;
            if(sqrt < mid) {
                right = mid-1;
            } else if (sqrt > mid) {
                left = mid+1;
            } else { // sqrt == mid
                return mid;
            }
        }
        return right;
    }
}
