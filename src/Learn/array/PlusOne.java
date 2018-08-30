package Learn.array;

import org.junit.Test;

/**
 * @author zhongtao on 2018/8/24
 */
public class PlusOne {
    //[1,2,3] [4,3,2,1] [4,3,2,9]
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length-1; i >=0; i--){
            if (digits[i]<9){
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newInts = new int[length + 1];
        newInts[0] = 1;
        return newInts;
    }

    /**
     * 测试plus one
     */
    @Test
    public void testPlusOne(){
        int[] difits = {9, 9, 9, 9};
        int[] ints = plusOne(difits);
        System.out.println(ints);
    }
}
