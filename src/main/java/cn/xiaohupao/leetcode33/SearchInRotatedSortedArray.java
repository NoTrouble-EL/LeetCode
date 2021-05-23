package cn.xiaohupao.leetcode33;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/23 14:30
 */
public class SearchInRotatedSortedArray {

    /**
     * There is an integer array nums sorted in ascending order (with distinct values).
     * Given the array nums after the rotation and an integer target,
     * return the index of target if it is in nums, or -1 if it is not in nums.
     * @param nums array nums after the rotation and an integer target
     * @param target target value
     * @return index of target
     *
     * time: O(log(n))
     * space: O(1)
     */
    public static int search(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return -1;
        }

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi){
            int mid = ((hi - lo) >> 1) + lo;
            if (nums[mid] == target){
                return mid;
            }

            if (nums[lo] <= nums[mid]){
                if (nums[lo] <= target && target < nums[mid]){
                    hi = mid - 1;
                }else {
                    lo = mid + 1;
                }
            }else{
                if (nums[mid] < target && target <= nums[hi]){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
