package Learn.HashTable;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * 例子
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 *
 * @author zhongtao on 2018/11/17
 */
public class NumJewelsInStones {

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<String> set = new HashSet<>();
        char[] Jchars = J.toCharArray();
        for (char jchar : Jchars) {
            set.add(String.valueOf(jchar));
        }
        char[] Schars = S.toCharArray();
        for (char schar : Schars) {
            boolean add = set.add(String.valueOf(schar));
            if (add) {
                set.remove(String.valueOf(schar));
            } else {
                count++;
            }
        }
        return count;
    }

    /**
     * 可以使用contains来判断
     */
    public int numJewelsInStones1(String J, String S) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) set.add(c);
        for (char c : S.toCharArray()) if (set.contains(c)) count++;
        return count;
    }

    /**
     * 直接循环判断
     */
    public int numJewelsInStones2(String J, String S) {
        int output = 0;
        char[] jewels = J.toCharArray();
        char[] myJewels = S.toCharArray();

        for (int i = 0; i < J.length(); i++) {
            for (int h = 0; h < S.length(); h++) {
                if (jewels[i] == myJewels[h]) {
                    output++;
                }
            }
        }
        return output;
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        System.out.println(numJewelsInStones("aAb", "aAAbbbccc"));
        System.out.println(numJewelsInStones1("aA", "aAAbbbccc"));
        System.out.println(numJewelsInStones2("aA", "aAAbbbccc"));
    }

}
