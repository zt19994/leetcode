package Learn.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 帕斯卡三角形
 *
 * @author zhongtao on 2018/9/15
 */
public class PascalsTriangle {

    /**
     * 生成每层的数组
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            //每一层多加一个数
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                //相当于用上一层两个数相加
                row.set(j, row.get(j) + row.get(j + 1));
            }
            allrows.add(new ArrayList<>(row));
        }
        return allrows;

    }


    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    //用上一层两个数相加
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    list.add(a + b);
                }
            }
            result.add(list);
        }
        return result;
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
