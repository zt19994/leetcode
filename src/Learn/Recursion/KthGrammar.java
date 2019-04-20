package Learn.Recursion;

import org.junit.Test;

/**
 * @author zt1994 2019/4/20 13:40
 */
public class KthGrammar {

    public int kthGrammar(int N, int K){
        return (N == 1) ? 0 : kthGrammar(N - 1, (K + 1) / 2) ^ (1 - (K % 2));
    }

    /**
    * 测试KthGrammar
    */
    @Test
    public void testKthGrammar(){
        System.out.println(kthGrammar(2, 1));
    }
}
