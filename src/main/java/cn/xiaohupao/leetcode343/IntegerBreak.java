package cn.xiaohupao.leetcode343;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/21 11:04
 */
public class IntegerBreak {

    public static int integerBreak(int n){
        // use dp

        int[] dp = new int[n+1];

        //init
        dp[2] = 1;
        for (int i = 3; i <= n; i++){
            for (int j = 1; j < i-1; j++){
                //状态转移方程:
                //dp[i]表示数字i可以分成最大的乘积
                //dp[i]可以分成(i-j)*j 或者(i-j)分解最大 * j
                dp[i] = Math.max(dp[i], j*Math.max(i-j, dp[i-j]));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
