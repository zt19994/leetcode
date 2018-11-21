package Learn.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 随机化的set
 * <p>
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 *
 * @author zhongtao on 2018/11/21
 */
public class RandomizedSet {

    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locations;
    Random rand = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        locations = new HashMap<Integer, Integer>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean contain = locations.containsKey(val);
        if (contain) {
            return false;
        }
        locations.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        boolean contain = locations.containsKey(val);
        if (!contain) {
            return false;
        }
        int loc = locations.get(val);
        //判断是否是最后一个数
        if (loc < nums.size() - 1) { // not the last one than swap the last one with this val
            int lastNum = nums.get(nums.size() - 1);
            nums.set(loc, lastNum);
            locations.put(lastNum, loc);
        }
        locations.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        //获取随机索引
        return nums.get(rand.nextInt(nums.size()));
    }
}
