package Learn.ArrayAndString;

import org.junit.Test;

/**
 * 移动非零元素
 * <p>
 * 给定一个数组nums，写一个函数把所有的0都移动到它的末尾，同时保持非零元素的相对顺序。
 *
 * @author zhongtao on 2018/9/20
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums){
        int k = 0;
        for(int i =0; i<nums.length; i++){
            if (nums[i] != 0){
                nums[k] = nums[i];
                k++;
            }
        }
        for (int j = k; j<nums.length; j++){
            nums[j] = 0;
        }
    }
    
    
    /**
     * 测试
     */
    @Test
    public void test(){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }
}
