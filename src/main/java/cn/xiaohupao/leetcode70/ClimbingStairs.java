package cn.xiaohupao.leetcode70;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/3 14:08
 */
public class ClimbingStairs {

    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * @param n steps to reach the top
     * @return how many distinct ways to the top
     *
     * time: O(n)
     * space: O(1)
     */
    public static int climbStairs(int n){
        int q = 0, p = 0, r = 1;
        for (int i = 1; i <= n; i++){
            q = p;
            p = r;
            r = q+p;
        }

        return r;
    }

    public static int climbStairs1(int n){
        //use dp
        int[] dp = new int[n+1];
        //初始化
        dp[1] = 1; dp[0] = 1;
        for (int i = 2; i <= n; i++){
            //dp[i]表示，在i阶上共有dp[i]种方法
            //状态转移方程：dp[i]的方法数 = dp[i-1]的方法数+dp[i-2]的方法数
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs1(3));
    }
}
