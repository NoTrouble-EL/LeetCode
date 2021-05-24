package cn.xiaohupao.leetcode37;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/24 15:50
 */
public class SudokuSolver {

    /**
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     * A sudoku solution must satisfy all of the following rules:
     * Each of the digits 1-9 must occur exactly once in each row.
     * Each of the digits 1-9 must occur exactly once in each column.
     * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
     * @param board Sudoku
     *
     * time: don't know
     * space: don't know
     */
    public static void solveSudoku(char[][] board){
        if (board == null || board.length == 0){
            return;
        }

        solve(board);
    }

    private static boolean solve(char[][] board){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.'){
                    for (char c = '1'; c <= '9'; c++){
                        if (isValid(board, i, j, c)){
                            board[i][j] = c;
                            if (solve(board)){
                                return true;
                            }else {
                                board[i][j] = '.';
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c){
        for (int i = 0; i < 9; i++){
            if (board[row][i] != '.' && board[row][i] == c){
                return false;
            }
            if (board[i][col] != '.' && board[i][col] == c){
                return false;
            }
            if (board[3*(row/3) + i/3][3*(col/3) + i%3] != '.' && board[3*(row/3) + i/3][3*(col/3) + i%3] == c){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'.','8','5','.','2','.','.','9','7'},
                {'.','1','.','7','4','.','.','8','3'},
                {'7','.','.','.','.','9','.','.','6'},
                {'9','2','.','8','.','.','.','.','.'},
                {'.','.','.','.','6','.','.','.','.'},
                {'8','.','.','3','9','.','.','.','.'},
                {'.','6','8','.','.','2','.','.','1'},
                {'.','4','.','.','5','.','6','.','.'},
                {'1','.','.','.','.','.','2','.','5'}};

        solveSudoku(board);

        for (char[] a : board){
            System.out.println(Arrays.toString(a));
        }
    }

}
