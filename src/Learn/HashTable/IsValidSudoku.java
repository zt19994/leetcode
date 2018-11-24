package Learn.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * 校验是否是数独
 *
 * @author zhongtao on 2018/11/24
 */
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    //同一行一列一个小块不能用重复的数
                    if (!set.add(number + " in row " + +i) ||
                        !set.add(number + " in column " + j) ||
                        !set.add(number + " in block " + i / 3 + "-" + j / 3)) {
                        return false;
                    }

                }
            }
        }
        return true;
    }
}
