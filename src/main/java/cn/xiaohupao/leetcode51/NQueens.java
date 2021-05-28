package cn.xiaohupao.leetcode51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/28 15:20
 */
public class NQueens {

    /**
     * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
     * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
     * Each solution contains a distinct board configuration of the n-queens' placement,
     * where 'Q' and '.' both indicate a queen and an empty space, respectively.
     * @param n n queens
     * @return answer in any order
     *
     * time: O(N!)
     * space: O(N)
     */
    public static List<List<String>> solveNQueens(int n){
        List<List<String>> res = new ArrayList<>();
        char[][] chess = new char[n][n];
        for (char[] ch : chess){
            Arrays.fill(ch, '.');
        }
        if (n <= 0){
            return res;
        }
        helper(res, chess, 0);

        return res;
    }

    private static void helper(List<List<String>> res, char[][] chess, int pos){
        if (pos == chess.length){
            res.add(array2List(chess));
        }

        for (int i = 0; i < chess.length; i++){
            if (isValid(pos, i, chess)){
                chess[pos][i] = 'Q';
                helper(res, chess, pos+1);
                chess[pos][i] = '.';
            }
        }
    }

    private static boolean isValid(int row, int col, char[][] chess){
        for (int i = 0; i < chess.length; i++){
            if (chess[i][col] == 'Q'){
                return false;
            }
        }

        for (int i = row-1, j = col-1; i>=0&&j>=0; i--, j--){
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
    private static List<String> array2List(char[][] chess){
        List<String> list = new ArrayList<>();
        for (char[] ch : chess){
            list.add(String.copyValueOf(ch));
        }

        return list;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
