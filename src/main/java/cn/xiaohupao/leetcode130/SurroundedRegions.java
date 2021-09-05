package cn.xiaohupao.leetcode130;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/5 19:11
 */
public class SurroundedRegions {
    /**
     * Given an m x n matrix board containing 'X' and 'O',
     * capture all regions that are 4-directionally surrounded by 'X'.
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     * @param board
     */
    public static void solve(char[][] board){
        //dfs
        //首先将边上的O以及相邻的O变成A

        for (int i = 0; i < board.length; i++){
            dfs(board, i, 0);
            dfs(board, i, board[0].length-1);
        }

        for(int i = 0; i < board[0].length; i++){
            dfs(board, 0, i);
            dfs(board, board.length-1, i);
        }

        //遍历二维数组，将A变成O，将O变成X
        for (int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private static void dfs(char[][] board, int i, int j){
        //corner case
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O'){
            return;
        }

        board[i][j] = 'A';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        solve(board);

        for (char[] charr : board){
            for (char ch : charr){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}
