package cn.xiaohupao.leetcode27;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/21 17:37
 */
public class RemoveElement {

    /**
     * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
     * @param nums an array nums
     * @param val a value val
     * @return new length
     *
     * time: O(n)
     * space: O(1)
     */
    public static int removeElement(int[] nums, int val){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[count++] = nums[i];
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }
}
