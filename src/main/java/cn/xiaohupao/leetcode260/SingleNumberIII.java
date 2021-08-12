package cn.xiaohupao.leetcode260;

import java.util.Arrays;

/**
 * @Author: Wukun
 * @Date: 2021/8/12下午5:29
 */
public class SingleNumberIII {

    /**
     * Given an integer array nums,
     * in which exactly two elements appear only once and all the other elements appear exactly twice.
     * Find the two elements that appear only once. You can return the answer in any order.
     * @param nums
     * @return
     *
     * time:O(n)
     * space:O(1)
     */
    public static int[] singleNumber(int[] nums){
        // XOR all numbers to get the XOR result of two numbers that only appear once
        int xor = 0;
        for (int n : nums){
            xor ^= n;
        }

        // Keep the two XOR results with the last bit as 1
        xor &= (-xor);

        // Create an array to save the results
        int[] res = new int[2];

        // Divide all numbers into two groups for XOR,
        // and the two numbers you want must be divided into two groups
        for (int n : nums){
            if ((xor & n) == 0){
                res[0] ^= n;
            }else {
                res[1] ^= n;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }
}
