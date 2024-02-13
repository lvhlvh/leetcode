package Q051N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return res;

        char[][] board = new char[n][n];
        for (char[] chars : board) Arrays.fill(chars, '.');
        // 从第0行开始放: 0, 1, 2, ...
        solveNQueens(board, 0);

        return res;
    }

    /**
     * 在第row行放置皇后
     */
    private void solveNQueens(char[][] board, int row) {
        if (row == board.length) {
            res.add(boardToList(board));
            return;
        }

        int nCol = board[0].length;
        for (int col = 0; col < nCol; ++col) {
            if (isValid(board, row, col)) {
                // 可以放置
                board[row][col] = 'Q';
                solveNQueens(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    /**
     * 判断当前位置 (row, col) 可不可以放置皇后
     */
    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;

        // 1. Up 竖直方向 ( < row 的行 )
        for (int i = 0; i < row; ++i) {
            if (board[i][col] == 'Q')
                return false;
        }

        // 2. 右上斜方向 take care
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j) {
            if (board[i][j] == 'Q')
                return false;
        }

        // 3. 左上斜方向 take care
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }


    private List<String> boardToList(char[][] board) {
        List<String> rows = new ArrayList<>();
        int n = board.length;
        for (char[] chars : board) {
            StringBuilder rowSb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                rowSb.append(chars[j]);
            }
            rows.add(rowSb.toString());
        }
        return rows;
    }
}
