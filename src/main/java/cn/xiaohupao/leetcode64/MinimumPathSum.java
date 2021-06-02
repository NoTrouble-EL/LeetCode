package cn.xiaohupao.leetcode64;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/2 16:46
 */
public class MinimumPathSum {

    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
     * which minimizes the sum of all numbers along its path.
     * @param grid m x n grid filled
     * @return minimizes the sum of all numbers along its path
     *
     * time: O(mxn)
     * space: O(1)
     */
    public static int minPathSum(int[][] grid){
        for (int i = 1; i < grid.length; i++){
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i < grid[0].length; i++){
            grid[0][i] += grid[0][i-1];
        }

        for (int i = 1; i < grid.length; i++){
            for (int j = 1; j < grid[0].length; j++){
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
