package cn.xiaohupao.leetcode322;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/21 10:34
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount){
        //use dp
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        //init
        dp[0] = 0;

        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (coins[j] <= i){
                    //状态转移方程：dp[i]表示总金额为i时最少的硬币组成
                    //dp[i] = MIN(dp[i], dp[i-coins[j]]+1)
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }

        return dp[amount] > amount ? -1: dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(coinChange(coins, 11));
    }
}
