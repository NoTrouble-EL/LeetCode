package cn.xiaohupao.leetcode799;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/4 19:55
 */
public class ChampagneTower {

    public static double champagneTower(int poured, int query_row, int query_glass){
        //dp
        //创建一个二维数组
        //使用模拟即可
        double[][] dp = new double[102][102];
        dp[0][0] = poured;

        for (int i = 0; i <= query_row; i++){
            for (int j = 0; j <= i; j++){
                //若p为正，则说明可以溢出；否则未满
                double p = (dp[i][j] - 1) / 2.0;
                if (p > 0){
                    dp[i+1][j] += p;
                    dp[i+1][j+1] += p;
                }
            }
        }

        return Math.min(1.0, dp[query_row][query_glass]);
    }

    public static void main(String[] args) {
        System.out.println(champagneTower(2,1, 1));
    }
}
