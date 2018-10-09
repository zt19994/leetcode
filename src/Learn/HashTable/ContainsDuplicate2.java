package Learn.HashTable;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数k，找出数组中是否有两个不同的索引i和j，比如nums i=nums j，i和j之间的绝对差最多是k。
 *
 * @author zhongtao on 2018/10/9
 */
public class ContainsDuplicate2 {
    public boolean containsNearByDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }


    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
    
    
    /**
     * 测试
     */
    @Test
    public void test(){
        int[] nums = {1,2,3,1};
        boolean b = containsNearByDuplicate(nums, 3);
        System.out.println(b);
    }
}
