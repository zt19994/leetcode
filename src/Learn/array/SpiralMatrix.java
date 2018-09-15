package Learn.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * @author zhongtao on 2018/8/25
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return res;
        }
        //开始纵坐标 多少排
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        //开始横坐标 每排多少个
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }

        return res;
    }



    public List<Integer> spiralOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<Integer>();
        }

        int[] borderVals = new int[]{1, (matrix[0].length - 1), (matrix.length - 1), 0}; //{top, right, bottom, left}
        List<Integer> spiral = new ArrayList();
        int totalLength = matrix.length * matrix[0].length;
        int i = 0; //vertical
        int j = 0; //horizontal
        char direction = 'r'; //start moving right from top-left corner


        while (totalLength > 0) {
            spiral.add(matrix[i][j]);

            if (checkForDirChange(borderVals, direction, i, j)) {
                char oldDir = direction;
                direction = changeDir(direction);
                adjustBorders(borderVals, oldDir);
            }

            switch (direction) {
                case 'l':
                    j--;
                    break;
                case 'u':
                    i--;
                    break;
                case 'r':
                    j++;
                    break;
                case 'd':
                    i++;
                    break;
            }

            totalLength--;
        }

        return spiral;
    }


    private void adjustBorders(int[] borders, char oldDir) {
        switch (oldDir) {
            case 'l':
                borders[3]++;
                break;
            case 'u':
                borders[0]++;
                break;
            case 'r':
                borders[1]--;
                break;
            case 'd':
                borders[2]--;
                break;
        }
    }


    private boolean checkForDirChange(int[] borders, char currDir, int i, int j) {
        boolean changeDir = false;

        switch (currDir) {
            case 'l':
                if (borders[3] == j) {
                    changeDir = true;
                }
                break;
            case 'u':
                if (borders[0] == i) {
                    changeDir = true;
                }
                break;
            case 'r':
                if (borders[1] == j) {
                    changeDir = true;
                }
                break;
            case 'd':
                if (borders[2] == i) {
                    changeDir = true;
                }
                break;
        }

        return changeDir;
    }


    private char changeDir(char currentDir) {
        char newDir = '0';
        switch (currentDir) {
            case 'l':
                newDir = 'u';
                break;
            case 'u':
                newDir = 'r';
                break;
            case 'r':
                newDir = 'd';
                break;
            case 'd':
                newDir = 'l';
                break;
        }

        return newDir;
    }
}
