package cn.xiaohupao.leetcode136;

/**
 * @Author: Wukun
 * @Date: 2021/8/11下午5:38
 */
public class SingleNumber {

    /**
     * Given a non-empty array of integers nums,
     * every element appears twice except for one.
     * Find that single one.
     * You must implement a solution with
     * a linear runtime complexity and use only constant extra space.
     * @param nums
     * @return
     *
     * time:O(n)
     * space:O(1)
     */
    public static int singleNumber(int[] nums){
        //Create a variable to save the result
        int res = 0;
        //Traverse all numbers
        for (int n : nums){
            res ^= n;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,6,8,6,4,2};
        System.out.println(singleNumber(nums));
    }
}
