package Learn.ArrayAndString;

import org.junit.Test;

/**
 * 最大公共前缀
 *
 * @author zhongtao on 2018/8/24
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder indexStr = new StringBuilder();
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        String result = "";
        String str1 = strs[0];
        for (int i = 0; i < str1.length(); i++) {
            indexStr.append(str1.charAt(i));
            String search = String.valueOf(indexStr);
            for (String str : strs) {
                if (str.indexOf(search) != 0) {
                    return result;
                }
            }
            result = search;
        }
        return result;
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(s) != 0)
                s = s.substring(0, s.length() - 1);
        }
        return s;
    }


    /**
     * 测试longestCommonPrefix
     */
    @Test
    public void testLongestCommonPrefix() {
        String[] strs = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
