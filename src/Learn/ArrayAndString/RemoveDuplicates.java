package Learn.ArrayAndString;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 移除副本
 * <p>
 * 给定一个已排序的数组nums，删除副本，这样每个元素只出现一次并返回新的长度。
 * 不要为另一个数组分配额外的空间，您必须通过修改输入数组和O（1）额外的内存来实现这一点。
 *
 * @author zhongtao on 2018/9/20
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int k = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])){
                set.add(nums[i]);
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }


    public int removeDuplicates1(int[] nums) {
        int i=0,j=1;
        while(i<nums.length-1 && j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                nums[++i] = nums[j];
                j++;
            }

        }
        return i+1;
    }
    
    
    /**
     * 测试
     */
    @Test
    public void test(){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
