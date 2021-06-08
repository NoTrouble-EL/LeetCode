package cn.xiaohupao.leetcode85;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/8 15:52
 */
public class MaximalRectangle {

    /**
     * Given a rows x cols binary matrix filled with 0's and 1's,
     * find the largest rectangle containing only 1's and return its area.
     * @param matrix  a rows x cols binary matrix filled with 0's and 1's
     * @return area
     *
     * time: O(mn)
     * space: O(mn)
     */
    public static int maximalRectangle(char[][] matrix){
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '1'){
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < m; i++){
            for (int j = 0; j < n; j++){
                if (dp[i-1][j] >= 1){
                    if (dp[i][j] == 1){
                        dp[i][j] = dp[i-1][j]+1;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++){
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);
            for (int j = 0; j < n; j++){
                while (stack.peek() != -1 && dp[i][stack.peek()] >= dp[i][j]){
                    res = Math.max(res, dp[i][stack.pop()] * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
            while (stack.peek() != -1){
                res = Math.max(res, dp[i][stack.pop()] * (n - stack.peek() - 1));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        char[][] matrix= {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
}
