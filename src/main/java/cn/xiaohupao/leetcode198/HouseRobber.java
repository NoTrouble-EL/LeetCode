package cn.xiaohupao.leetcode198;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/21 9:41
 */
public class HouseRobber {

    public static int rob(int[] nums){
        //use dp
        int n = nums.length;
        int[] dp = new int[n];
        //初始化
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], dp[1]);

        for (int i = 2; i < n; i++){
            //状态转移方程：当前最大收益dp[i] = MAX(当前房子偷nums[i]+dp[i-2]的收益，dp[i-1]即当前房子不偷)
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
}
