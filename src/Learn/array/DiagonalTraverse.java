package Learn.array;

/**
 * 对角线遍历
 *
 * @author zhongtao on 2018/8/25
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[] result = new int[m * n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row += dirs[d][0];
            col += dirs[d][1];

            if (row >= m) {
                row = m - 1;
                col += 2;
                d = 1 - d;
            }
            if (col >= n) {
                col = n - 1;
                row += 2;
                d = 1 - d;
            }
            if (row < 0) {
                row = 0;
                d = 1 - d;
            }
            if (col < 0) {
                col = 0;
                d = 1 - d;
            }
        }

        return result;
    }

    public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int[] result = new int[matrix.length * matrix[0].length];

        int x = 0;
        int y = 0;
        int count = 0;
        boolean up = true;

        while (count < result.length) {
            result[count] = matrix[x][y];
            if (up) {
                if (y < matrix[0].length - 1 && x == 0) {
                    y++;
                    up = false;
                } else if (y == matrix[0].length - 1) {
                    x++;
                    up = false;
                } else {
                    x--;
                    y++;
                }
            } else {
                if (x < matrix.length - 1 && y == 0) {
                    x++;
                    up = true;
                } else if (x == matrix.length - 1) {
                    y++;
                    up = true;
                } else {
                    x++;
                    y--;
                }
            }
            count++;
        }
        return result;
    }
}
