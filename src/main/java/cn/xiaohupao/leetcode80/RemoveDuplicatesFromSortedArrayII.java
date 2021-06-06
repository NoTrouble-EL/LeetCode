package cn.xiaohupao.leetcode80;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/6 18:36
 */
public class RemoveDuplicatesFromSortedArrayII {

    /**
     * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
     * Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
     * @param nums a sorted array nums
     * @return new length
     *
     * time: O(n)
     * space: O(1)
     */
    public static int removeDuplicates(int[] nums){
        if (nums == null || nums.length <= 2){
            return nums.length;
        }

        int i = 2;
        for (int j = 2; j < nums.length ;j++){
            if (nums[i-2] != nums[j]){
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }
}
