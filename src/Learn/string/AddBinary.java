package Learn.string;

import org.junit.Test;

/**
 * @author zhongtao on 2018/8/24
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        // 进位
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        //取反
        return sb.reverse().toString();
    }

    public String addBinary1(String a, String b) {
        char[] result = new char[Math.max(a.length(), b.length())];
        int carryBit = 0;
        for (int a1 = a.length() - 1, a2 = b.length() - 1; a1 >= 0 || a2 >= 0; --a1, --a2) {
            int c1 = a1 < 0 ? 0 : (a.charAt(a1) - '0');
            int c2 = a2 < 0 ? 0 : (b.charAt(a2) - '0');
            result[Math.max(a1, a2)] = (char) ((c1 + c2 + carryBit) % 2 + (int) '0');

            if ((c1 + c2 + carryBit) / 2 > 0) {
                carryBit = 1;
            } else {
                carryBit = 0;
            }
        }
        return (carryBit > 0 ? "1" : "") + new String(result);
    }

    /**
     * 测试添加二进制
     */
    @Test
    public void testAddBinary() {
        System.out.println(addBinary("11", "1"));

        System.out.println(addBinary1("1010", "1011"));

        System.out.println(addBinary2("1010", "1011"));
    }

    public String addBinary2(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        int carryBit = 0;
        while (aLength >= 0 || bLength >= 0) {
            int sum = carryBit;
            if (aLength >= 0) {
                sum += a.charAt(aLength--) - '0';
            }
            if (bLength >= 0) {
                sum += b.charAt(bLength--) - '0';
            }
            stringBuilder.append(sum % 2);
            carryBit = sum / 2;
        }
        if (carryBit > 0) {
            stringBuilder.append(carryBit);
        }
        return stringBuilder.reverse().toString();
    }
}
