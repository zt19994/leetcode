package Learn.queue;

/**
 * 岛屿的数量
 *
 * @author zhongtao on 2018/8/28
 */
public class NumberofIslands {

    private int n;
    private int m;

    public int numsIslands(char[][] grid) {
        int count = 0;
        //网格宽
        n = grid.length;
        if (n == 0) return 0;
        //网格长
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    DFSGrid(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void DFSGrid(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        //将该格设为0
        grid[i][j] = '0';
        DFSGrid(grid, i + 1, j);
        DFSGrid(grid, i - 1, j);
        DFSGrid(grid, i, j + 1);
        DFSGrid(grid, i, j - 1);
    }


    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}
