package cn.xiaohupao.leetcode16;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/18 15:15
 */
public class ThreeSumClosest {

    /**
     * Given an array nums of n integers and an integer target,
     * find three integers in nums such that the sum is closest to target.
     * Return the sum of the three integers.
     * You may assume that each input would have exactly one solution.
     * @param nums Array - an array nums of n integers
     * @param target int - integer target
     * @return int - sum of the three integers whitch closest to target
     *
     * time: O(n^2)
     * space: O(1)
     */
    public static int threeSumClosest(int[] nums, int target){
        int res = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++){
            int lo = i+1, hi = nums.length-1;
            while (lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum > target){
                    hi--;
                }else{
                    lo++;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
