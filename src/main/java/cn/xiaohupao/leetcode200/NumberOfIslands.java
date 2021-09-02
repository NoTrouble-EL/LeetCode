package cn.xiaohupao.leetcode200;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/2 19:35
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid){
        //corner case
        if (grid == null || grid.length == 0){
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    count++;
                    helper(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void helper(char[][] grid, int i, int j){
        //corner case
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        helper(grid, i, j+1);
        helper(grid, i, j-1);
        helper(grid, i+1, j);
        helper(grid, i-1, j);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };

        System.out.println(numIslands(grid));
    }
}
