package cn.xiaohupao.leetcode300;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/6 15:51
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums){
        //corner case
        if (nums == null || nums.length == 0){
            return 0;
        }

        //use dp
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int res = 1;

        //遍历数组
        for (int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
