package Learn.HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计hashSet
 *
 * @author zhongtao on 2018/9/25
 */
public class MyHashSet {
    private int buckets = 1000;
    private int itemsPerBucket = 1001;
    private boolean[][] table;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        table = new boolean[buckets][];
    }

    public int hash(int key) {
        return key % buckets;
    }

    public int pos(int key) {
        return key / buckets;
    }

    public void add(int key) {
        int hashkey = hash(key);

        if (table[hashkey] == null) {
            table[hashkey] = new boolean[itemsPerBucket];
        }
        table[hashkey][pos(key)] = true;
    }

    public void remove(int key) {
        int hashkey = hash(key);

        if (table[hashkey] != null)
            table[hashkey][pos(key)] = false;
    }

    /**
     * Returns true if this set did not already contain the specified element
     */
    public boolean contains(int key) {
        int hashkey = hash(key);
        return table[hashkey] != null && table[hashkey][pos(key)];
    }


    /**
     * 使用列表
     */
    class MyHashSet1 {

        private List<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet1() {
            list = new ArrayList<Integer>();
        }

        public void add(int key) {
            if (!list.contains(key)) {
                list.add(key);
            }
        }

        public void remove(int key) {
            if (list.contains(key)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals(key)) {
                        list.remove(i);
                        break;
                    }
                }
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return list.contains(key);
        }
    }
}
