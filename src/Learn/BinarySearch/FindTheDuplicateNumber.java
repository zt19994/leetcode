package Learn.BinarySearch;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个包含n + 1个整数的数组数字，其中每个整数在1到n之间(包括在内)，
 * 证明至少存在一个重复的数字。假设只有一个重复的数字，找到这个重复的数字。
 * <p>
 * Input: [1,3,4,2,2]
 * Output: 2
 * <p>
 * Input: [3,1,3,4,2]
 * Output: 3
 *
 * @author zhongtao on 2019/1/5
 */
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                result = nums[i];
            }
            set.add(nums[i]);
        }
        return result;
    }

    public int findDuplicate1(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) break;
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * 测试
     */
    @Test
    public void test() {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate1(nums));
    }
}
