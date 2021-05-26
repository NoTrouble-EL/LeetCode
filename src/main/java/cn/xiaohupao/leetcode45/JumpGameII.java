package cn.xiaohupao.leetcode45;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/26 16:16
 */
public class JumpGameII {

    /**
     * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Your goal is to reach the last index in the minimum number of jumps.
     * You can assume that you can always reach the last index.
     * @param nums integers nums
     * @return minimum number of jumps
     *
     * time: O(n)
     * space: O(1)
     */
    public static int jump(int[] nums){
        if (nums == null || nums.length < 2){
            return 0;
        }

        int res = 0;
        int curMax = 0, nextMax = 0;
        for (int i = 0; i < nums.length - 1; i++){
            nextMax = Math.max(nextMax, i + nums[i]);
            if (i == curMax){
                curMax = nextMax;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
