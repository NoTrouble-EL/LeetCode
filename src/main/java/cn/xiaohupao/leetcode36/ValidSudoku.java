package cn.xiaohupao.leetcode36;

import java.util.HashSet;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/24 14:09
 */
public class ValidSudoku {

    /**
     * Determine if a 9 x 9 Sudoku board is valid.
     * Only the filled cells need to be validated according to the following rules:
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * @param board Sudoku
     * @return true - Sudoku board is valid
     *
     * time: O(1)
     * space: O(1)
     */
    public static boolean isValidSudoku(char[][] board){
        for (int i = 0; i < board.length; i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != '.' && !rows.add(board[i][j])){
                    return false;
                }
                if (board[j][i] != '.' && !cols.add(board[j][i])){
                    return false;
                }

                int rowIndex = 3 * (i / 3), colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' &&
                !cube.add(board[rowIndex + j / 3][colIndex + j % 3])){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }
}
