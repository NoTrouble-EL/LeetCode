package cn.xiaohupao.leetcode53;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/29 19:34
 */
public class MaximunSubarray {

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     * @param nums an integer array nums
     * @return largest sum
     *
     * time: O(n)
     * space: O(n)
     */
    public static int maxSubArray(int[] nums){
        if (nums.length == 0){
            return nums[0];
        }
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = res;
        for (int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
