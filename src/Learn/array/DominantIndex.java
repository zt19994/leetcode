package Learn.array;

/**
 * @author zhongtao on 2018/8/22
 */
public class DominantIndex {

    public int dominantIndex(int[] nums) {
        int top1 = 0;
        int top1Index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>top1){
                top1 = nums[i];
                top1Index = i;
            }
        }
        nums[top1Index] = 0;
        int top2 = 0;
        for (int num : nums) {
            if (num>top2){
                top2 = num;
            }
        }

        if (top2*2>top1){
            return -1;
        }
        return top1Index;
    }

    public int dominantIndex2(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }
}
