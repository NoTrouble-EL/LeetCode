package cn.xiaohupao.leetcode31;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/22 15:46
 */
public class NextPermutation {

    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
     * @param nums an array
     *
     * time: O(n)
     * space: O(1)
     */
    public static void nextPermutation(int[] nums){
        if (nums == null || nums.length == 0){
            return;
        }

        int firstSmall = -1;
        for (int i = nums.length - 2; i >= 0; i--){
            if (nums[i] < nums[i+1]){
                firstSmall = i;
                break;
            }
        }

        if (firstSmall == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }

        int secondeSmall = -1;
        for (int i = nums.length-1; i > firstSmall; i--){
            if (nums[i] > nums[firstSmall]){
                secondeSmall = i;
                break;
            }
        }

        swap(nums, firstSmall, secondeSmall);
        reverse(nums, firstSmall+1, nums.length-1);
    }

    private static void reverse(int[] nums, int lo, int hi){
        while (lo < hi){
            swap(nums, lo++, hi--);
        }
    }

    private static void swap(int[] nums, int lo, int hi){
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
