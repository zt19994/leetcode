package Learn.HashTable;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 包含重复
 *
 * @author zhongtao on 2018/9/26
 */
public class ContainsDuplicate {

    /**
     * 将nums加入set中，通过比较长度判断是否有重复的数字
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        int length = nums.length;
        for (int num : nums) {
            hashSet.add(num);
        }
        int size = hashSet.size();
        return length != size;
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}
