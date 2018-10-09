package Learn.HashTable;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 找到字符串中第一个唯一字符
 *
 * @author zhongtao on 2018/10/5
 */
public class FirstUniqueCharacter {
    public int firstUniqChar1(String s) {
        //1、设置26长度的数组
        int[] freq = new int[26];
        //2、遍历字符串，在数组中加一
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++; //找到指定索引
        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)  //第一个唯一字符
                return i;
        return -1;
    }

    public int firstUniqChar2(String s) {
        Map<Character, int[]> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int[] stored = map.get(ch);
            if (stored == null){
                stored = new int[]{1, i};
            } else{
                stored[0]++;
            }
            map.put(ch, stored);
        }

        for (char ch : map.keySet()) {
            int[] stored = map.get(ch);
            if (stored[0] == 1)
                return stored[1];
        }
        return -1;
    }

    /**
     * 测试
     */
    @Test
    public void test() {
        System.out.println(firstUniqChar1("leetcode"));
    }
}
