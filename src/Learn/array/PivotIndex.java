package Learn.array;

import org.junit.Test;

/**
 * @author zhongtao on 2018/8/22
 */
public class PivotIndex {

    public int pivotIndex1(int[] nums) {
        int size = nums.length;
        if (size<1){
            return -1;
        }
        int resultIndex = -1;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < size; i++) {
            leftSum = 0;
            rightSum = 0;
            for (int j = 0; j<i; j++){
                leftSum +=nums[j];
            }
            for (int k = i+1; k<size; k++){
                rightSum +=nums[k];
            }
            if (leftSum==rightSum){
                resultIndex = i;
                break;
            }
        }
        return resultIndex;
    }


    public int pivotIndex2(int[] nums){
        int allSum = 0;
        for (int num : nums) {
            allSum += num;
        }
        int size = nums.length;
        int leftSum = 0;
        for (int i = 0; i < size; i++) {
            if (leftSum == allSum - leftSum - nums[i]){
                return i;
            }
            leftSum +=nums[i];
        }
        return -1;
    }
    
    /**
     * 
     */
    @Test
    public void test(){
        int[] nums = {-1,-1,0,0,-1,-1};
        int i = pivotIndex1(nums);
        int i1 = pivotIndex2(nums);
        System.out.println(i+ "   " + i1);
    }
}
