package Learn.string;

import org.junit.Test;

/**
 * @author zhongtao on 2018/8/24
 */
public class FindstrStr {

    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return 0;
        }
        int h1 = haystack.length();
        int n1 = needle.length();
        int result = 0;
        int i = 0;
        int j = 0;
        for (i = 0; i < h1; i++) {
            j = 0;
            while (i + j < h1 && j < n1 && haystack.charAt(i + j) == needle.charAt(j)) {
                result = i;
                j++;
            }
            if (j == n1) {
                break;
            }
        }
        if (j != n1) {
            return -1;
        }
        return result;
    }

    public int strStr1(String haystack, String needle){
        if(needle.length()>haystack.length()){
            return -1;
        }
        if(haystack==null || haystack.length()==0 || needle==null || needle.length()==0){
            return 0;
        }
        return haystack.indexOf(needle)>=0?haystack.indexOf(needle):-1;
    }

    /**
     * 测试strStr
     */
    @Test
    public void testStr() {
        System.out.println(strStr1("hello", "ll"));
    }
}
