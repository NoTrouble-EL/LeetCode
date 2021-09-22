package cn.xiaohupao.leetcode416;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/22 8:33
 */
public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums){
        //计算sum,和最大值max
        int sum = 0, max = -1;
        for (int num : nums){
            sum += num;
            max = Math.max(num, max);
        }

        if ((sum & 1) == 1){
            return false;
        }

        if (max > (sum >> 1)){
            return false;
        }

        // use dp
        boolean[][] dp = new boolean[nums.length][(sum >> 1)+1];
        //init
        if (nums[0] < (sum >> 1)){
            dp[0][nums[0]] = true;
        }

        //状态转移
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j <= (sum >> 1); j++){
                //dp[i][j]表示，使用数组中0~i能够组成值为j，是否存在
                //若dp[i-1][j]存在，则dp[i][j]也存在，不使用nums[i]的情况
                dp[i][j] = dp[i-1][j];
                //使用nums[i]时的情况，若nums[i]==j，则必存在dp[i][j]为true
                if (nums[i] == j){
                    dp[i][j] = true;
                }
                //使用nums[i]时的情况，若nums[i] < j，则dp[i-1][j]存在或dp[i-1][j-nums[i]]存在即存在
                if (nums[i] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][sum >> 1];
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }
}
