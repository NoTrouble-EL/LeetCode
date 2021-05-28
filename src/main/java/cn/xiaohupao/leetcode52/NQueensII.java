package cn.xiaohupao.leetcode52;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/28 16:17
 */
public class NQueensII {

    private static int res = 0;

    /**
     * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
     * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
     * @param n n queens
     * @return the number of distinct solutions to the n-queens puzzle
     *
     * time: O(N!)
     * space: O(N)
     */
    public static int totalNQueens(int n){
        if (n <= 0){
            return res;
        }
        char[][] chess = new char[n][n];
        for (char[] ch : chess){
            Arrays.fill(ch, '.');
        }
        helper(chess, 0);

        return res;
    }

    private static void helper(char[][] chess, int pos){
        if (pos == chess.length){
            res++;
        }

        for (int i = 0; i < chess.length; i++){
            if (isValid(pos, i, chess)){
                chess[pos][i] = 'Q';
                helper(chess, pos+1);
                chess[pos][i] = '.';
            }
        }
    }

    private static boolean isValid(int row, int col, char[][] chess){
        for (int i = 0; i < row; i++){
            if (chess[i][col] == 'Q'){
                return false;
            }
        }

        for (int i = row-1, j = col-1; i>=0&&j>=0; i--,j--){
            if (chess[i][j] == 'Q'){
                return false;
            }
        }

        for (int i = row-1, j = col+1; i>=0&&j<=chess.length-1; i--,j++){
            if (chess[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int n = 8;
        System.out.println(totalNQueens(n));
    }
}
