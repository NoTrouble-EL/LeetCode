package cn.xiaohupao.leetcode75;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/5 12:16
 */
public class SortColors {

    /**
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
     * with the colors in the order red, white, and blue.
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     * You must solve this problem without using the library's sort function.
     * @param nums an array nums
     *
     * time: O(n)
     * space: O(1)
     */
    public static void sortColors(int[] nums){
        int zero = 0, two = nums.length-1;
        int i = 0;
        while (i <= two){
            if (nums[i] == 0){
                swap(nums, zero, i);
                zero++;
            }else if(nums[i] == 2){
                swap(nums, two, i);
                two--;
            }else{
                i++;
            }

            i = Math.max(i, zero);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
