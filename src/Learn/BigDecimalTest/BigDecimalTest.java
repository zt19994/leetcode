package Learn.BigDecimalTest;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_DOWN;

/**
 * @author zhongtao on 2018/8/20
 */
public class BigDecimalTest {

    /**
     * 测试减法 参数类型是double类型，计算还是不精确
     */
    @Test
    public void testSubtract1(){
        BigDecimal b1 = new BigDecimal(0.05);
        BigDecimal b2 = new BigDecimal(0.01);
        System.out.println(b1.subtract(b2));
        //输出：0.04000000000000000256739074444567449972964823246002197265625
    }

    /**
     * 测试减法，参数类型是String类型，计算结果精确
     */
    @Test
    public void testSubtract2(){
        BigDecimal b1 = new BigDecimal("0.05");
        BigDecimal b2 = new BigDecimal("0.01");
        System.out.println(b1.subtract(b2));
        //输出：0.04
    }

    /**
     * 测试乘法 参数类型是double类型，计算还是不精确
     */
    @Test
    public void testMultiply1(){
        BigDecimal b1 = new BigDecimal(0.05);
        BigDecimal b2 = new BigDecimal(0.01);
        System.out.println(b1.multiply(b2));
        //输出：0.0005000000000000000381639164714897566548413219067927041589808827754781955614304944646164585719816386699676513671875
    }


    /**
     * 测试乘法，参数类型是String类型，计算结果精确
     */
    @Test
    public void testMultiply2(){
        BigDecimal b1 = new BigDecimal("0.05");
        BigDecimal b2 = new BigDecimal("0.01");
        System.out.println(b1.multiply(b2));
        //输出：0.0005
    }

    /**
     * 测试除法 参数类型是double类型
     */
    @Test
    public void testDivide1(){
        BigDecimal b1 = new BigDecimal(0.1);
        BigDecimal b2 = new BigDecimal(0.03);
        System.out.println(b1.divide(b2));
        //报错 java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
    }

    /**
     * 测试除法，参数类型是String类型
     */
    @Test
    public void testDivide2(){
        BigDecimal b1 = new BigDecimal("0.1");
        BigDecimal b2 = new BigDecimal("0.03");
        System.out.println(b1.divide(b2));
        //报错 java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
    }


    /**
     * 测试除法 参数类型是double类型
     */
    @Test
    public void testDivide3(){
        BigDecimal b1 = new BigDecimal(0.1);
        BigDecimal b2 = new BigDecimal(0.03);
        System.out.println(b1.divide(b2, 10, ROUND_HALF_DOWN));
        //输出：3.3333333333
    }

    /**
     * 测试除法，参数类型是String类型
     */
    @Test
    public void testDivide4(){
        BigDecimal b1 = new BigDecimal("0.1");
        BigDecimal b2 = new BigDecimal("0.03");
        System.out.println(b1.divide(b2, 10, ROUND_HALF_DOWN));
        //输出：3.3333333333
    }
}
