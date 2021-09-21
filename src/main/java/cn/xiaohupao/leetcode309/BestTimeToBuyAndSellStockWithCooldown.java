package cn.xiaohupao.leetcode309;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/21 9:58
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public static int maxProfit(int[] prices){
        //use dp

        int n = prices.length;

        //use 二维dp
        int[][] dp = new int[n][3];

        //init
        dp[0][0] = -prices[0];

        for (int i = 1; i < n; i++){
            //状态转移方程:
            //dp[i][0]：表示第i天的状态为持有股票时最大的收益
            //可以由i-1天持有股票时的最大收益 或 i-1天即不持有股票也不解冻-当前股价
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]-prices[i]);
            //dp[i][1]：表示第i天的状态为无持股并且在冷冻状态的最大收益
            //可以由i-1天持股在当前卖出转移
            dp[i][1] = dp[i-1][0]+prices[i];
            //dp[i][2]：表示第i天的状态为即无持有股票也不冷冻状态的最大收益
            //可以由i-1天即无持有股票也不冷冻状态 或 i-1天处于冷冻状态转移
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
        }

        return Math.max(dp[n-1][1], dp[n-1][2]);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,0,2};
        System.out.println(maxProfit(nums));
    }
}
