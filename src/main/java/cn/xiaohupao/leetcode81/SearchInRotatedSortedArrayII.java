package cn.xiaohupao.leetcode81;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/7 10:27
 */
public class SearchInRotatedSortedArrayII {

    /**
     * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
     * @param nums an integer array nums sorted in non-decreasing order
     * @param target an target number
     * @return true if target number in the array nums
     *
     * time: O(n)
     * space: O(1)
     */
    public static boolean search(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return false;
        }
        if (nums.length == 1){
            return nums[0] == target;
        }

        int lo = 0, hi = nums.length-1;
        while (lo <= hi){
            int mid = ((hi - lo) >> 1) + lo;
            if (nums[mid] == target){
                return true;
            }

            if (nums[lo] == nums[mid] && nums[mid] == nums[hi]){
                lo++;
                hi--;
            }else if(nums[lo] <= nums[mid]){
                if (nums[lo] <= target && target < nums[mid]){
                    hi = mid - 1;
                }else{
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

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
