package cn.xiaohupao.leetcode26;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/21 17:16
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
     * @param nums a sorted array nums
     * @return int - new length
     *
     * time: O(n)
     * space: O(1)
     */
    public static int removeDuplicates(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int count = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] != nums[i]){
                nums[count++] = nums[i];
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}
