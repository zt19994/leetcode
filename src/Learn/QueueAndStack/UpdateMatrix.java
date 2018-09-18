package Learn.QueueAndStack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由0和1组成的矩阵，求出每个单元格最近的0的距离。
 * 两个相邻细胞之间的距离是1
 *
 * @author zhongtao on 2018/9/14
 */
public class UpdateMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //将矩阵中所有的点存储在queue中
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    //设为最大值
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        //方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            //循环找到点的上下左右的点
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                //判断点的大小
                if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[]{r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        return matrix;
    }


    /**
     *
     */
    @Test
    public void test(){
        int result = Integer.MAX_VALUE + 1;
        System.out.println(result);
    }
}
