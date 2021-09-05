package cn.xiaohupao.leetcode221;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/5 20:57
 */
public class MaximalSquare {

    public static int maximalSquare(char[][] matrix){
        //use dp

        //corner case
        if (matrix == null || matrix.length == 0){
            return 0;
        }

        //result
        int res = 0;

        //创建一个dp二维数组
        int[][] dp = new int[matrix.length][matrix[0].length];

        //遍历二维数组
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == '1'){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    }
                }

                res = Math.max(res, dp[i][j]);
            }
        }

        return res*res;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}

        };
        System.out.println(maximalSquare(matrix));
    }
}
