package cn.xiaohupao.leetcode34;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/23 15:28
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     * If target is not found in the array, return [-1, -1].
     * @param nums an array of integers nums sorted
     * @param target target value
     * @return starting and ending position of a given target value
     *
     * time: O(log(n))
     * space: O(1)
     */
    public static int[] searchRange(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }

        int first = searchFirst(nums, target);
        if (first == -1){
            return new int[]{-1, -1};
        }
        int last = searchLast(nums, target);

        return new int[]{first, last};
    }

    private static int searchFirst(int[] nums, int target){
        int lo = 0, hi = nums.length-1;
        while (lo <= hi){
            int mid = ((hi - lo) >> 1) + lo;
            if (nums[mid] < target){
                lo = mid + 1;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else{
                if (mid == 0 || nums[mid-1] != target){
                    return mid;
                }else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

    private static int searchLast(int[] nums, int target){
        int lo = 0, hi = nums.length-1;
        while (lo <= hi){
            int mid = ((hi - lo) >> 1) + lo;
            if (nums[mid] < target){
                lo = mid + 1;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else{
                if (mid == nums.length-1 || nums[mid+1] != target){
                    return mid;
                }else {
                    lo = mid + 1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
