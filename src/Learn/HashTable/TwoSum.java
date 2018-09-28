package Learn.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个数之和
 *
 * @author zhongtao on 2018/9/27
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return null;

        Map<Integer, Integer> map = new HashMap<>(); // key: number, value: index of the number in array
        for(int i = 0; i < nums.length; i++){
            int val = nums[i];
            Integer other = map.get(target - val); // check if we have another number needed for sum in the map already
            if(other != null){
                return new int[]{other, i};
            } else{
                map.put(val, i);
            }
        }
        return null;
    }

}
