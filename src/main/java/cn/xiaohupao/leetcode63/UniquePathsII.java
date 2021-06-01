package cn.xiaohupao.leetcode63;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/1 17:51
 */
public class UniquePathsII {

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * An obstacle and space is marked as 1 and 0 respectively in the grid.
     * @param obstacleGrid an obstacle and space is marked as 1 and 0 respectively is the grid
     * @return possible unique paths are there
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid.length && obstacleGrid[i][0] == 0; i++){
            dp[i][0] = 1;
        }
        for (int i = 0; i < obstacleGrid[0].length && obstacleGrid[0][i] == 0; i++){
            dp[0][i] = 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++){
            for (int j = 1; j < obstacleGrid[0].length; j++){
                if (obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
