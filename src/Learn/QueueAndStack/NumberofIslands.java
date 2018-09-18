package Learn.QueueAndStack;

/**
 * 岛屿的数量
 * <p>
 * 给定一个“1”（陆地）和“0”（水）的2d网格地图，计算岛屿的数量。
 * 一个岛屿被水包围，是通过水平或垂直连接相邻的土地形成的。
 * 你可以假设网格的所有四条边都被水包围着。
 *
 * @author zhongtao on 2018/8/28
 */
public class NumberofIslands {

    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        //岛屿总数
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

    /**
     * 深度优先 把1变为0，防止多次遍历
     */
    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}
