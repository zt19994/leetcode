package Learn.ArrayAndString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 帕斯卡三角形2
 *
 * @author zhongtao on 2018/9/20
 */
public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> allRows = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            allRows.add(row);
        }
        return allRows.get(rowIndex);
    }


    /**
     * 不同构建完整的帕斯卡三角，只要找到需要的哪一行即可
     */
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(1);
            for (int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        List<Integer> row = getRow(5);
        for (Integer integer : row) {
            System.out.println(integer);
        }
    }
}
