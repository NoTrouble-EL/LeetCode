package cn.xiaohupao.leetcode62;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/1 16:25
 */
public class UniquePaths {

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * How many possible unique paths are there?
     * @param m width
     * @param n length
     * @return possible unique paths are there
     *
     * time: O(m)
     * space: O(1)
     */
    public static int uniquePaths(int m, int n){
        long res = 1;
        for (int i = n, j = 1; j < m; i++, j++){
            res =  res * i / j;
        }

        return (int) res;
    }

    public static int uniquePathsII(int m, int n){
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePathsII(3,7));
    }
}
