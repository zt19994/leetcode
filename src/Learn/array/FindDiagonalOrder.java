package Learn.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongtao on 2018/8/23
 */
public class FindDiagonalOrder {
    public List<Integer> findDiagonalOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            if (i/2==0){
                for (int i1 = 0; i1 < i; i1++) {
                    result.add(matrix[i1][i - i1]);
                }
            }else {
                for (int i1 = 0; i1 < i; i1++) {
                    result.add(matrix[i-i1][i]);
                }
            }
        }
        for (int i = size-1; i>=size-1 ; i--){
            if (i/2!=0){
                for (int i1 = 0; i1 < i; i1++) {
                    result.add(matrix[i1][i - i1]);
                }
            }else {
                for (int i1 = 0; i1 < i; i1++) {
                    result.add(matrix[i-i1][i]);
                }
            }
        }
        return result;
    }
    
    
    /**
     * 
     */
    @Test
    public void test(){
        int[][] matrix = { {1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }};
        List<Integer> diagonalOrder = findDiagonalOrder(matrix);
        System.out.println(diagonalOrder.toString());
    }
}
