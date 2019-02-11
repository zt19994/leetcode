package Learn.Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 帕斯卡三角
 *
 * @author zt1994 2019/2/11 12:15
 */
public class PascalTriangle {

    /**
     * 使用递归方法求解
     * <p>
     * 给定一个非负整数numRows，生成一个numRows行的帕斯卡三角形。
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<List<Integer>>();
        if (numRows > 0) {
            helper(numRows - 1, rows);
        }
        return rows;
    }

    private void helper(int numRows, List<List<Integer>> rows) {
        if (numRows == 0) {
            rows.add(Arrays.asList(1));
            return;
        }
        helper(numRows - 1, rows);
        //基于上一行构造当前行
        List<Integer> curRow = new ArrayList<>();
        List<Integer> prevRow = rows.get(numRows - 1);
        curRow.add(1);
        for (int i = 0; i < prevRow.size() - 1; i++){
            curRow.add(prevRow.get(i) + prevRow.get(i + 1));
        }
        curRow.add(1);
        rows.add(curRow);
    }

    /**
     * 测试
     */
    @Test
    public void test() {
        List<List<Integer>> generate = generate(5);
        System.out.println(generate);
    }
}
