package cn.xiaohupao.leetcode41;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/25 15:59
 */
public class FirstMissingPositive {

    /**
     * Given an unsorted integer array nums, find the smallest missing positive integer.
     * You must implement an algorithm that runs in O(n) time and uses constant extra space.
     * @param nums an unsorted integer array nums
     * @return smallest missing positive
     *
     * time: O(n)
     * space: O(1)
     */
    public static int firstMissingPositive(int[] nums){
        if (nums == null || nums.length == 0){
            return 1;
        }

        for (int i = 0; i < nums.length; i++){
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != (i+1)){
                return (i+1);
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));
    }
}
