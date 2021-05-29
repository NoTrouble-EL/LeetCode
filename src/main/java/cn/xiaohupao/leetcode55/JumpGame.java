package cn.xiaohupao.leetcode55;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/29 20:56
 */
public class JumpGame {

    /**
     * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Determine if you are able to reach the last index.
     * @param nums non-negative integers nums
     * @return true represents it is able to reach the last index
     *
     * time: O(n)
     * space: O(1)
     */
    public static boolean canJump(int[] nums){
        int curMax = 0, nextMax = 0;
        for (int i = 0; i < nums.length; i++){
            nextMax = Math.max(nextMax, nums[i]+i);
            if (i == curMax){
                curMax = nextMax;
            }

            if (curMax >= nums.length-1){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}
