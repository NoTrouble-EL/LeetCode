package cn.xiaohupao.leetcode35;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/23 15:59
 */
public class SearchInsertPosition {

    /**
     * Given a sorted array of distinct integers and a target value,
     * return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     * @param nums a sorted array
     * @param target target value
     * @return the index if the target is found. If not, return the index where it would be if it were inserted in order
     *
     * time: O(log(n))
     * space: O(1)
     */
    public static int searchInsert(int[] nums, int target){
        int lo = 0, hi = nums.length-1;

        while (lo <= hi){
            int mid = ((hi - lo) >> 1) + lo;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                hi = mid - 1;
            }else{
                if (mid == nums.length-1 || nums[mid+1] > target){
                    return mid+1;
                }else {
                    lo = mid + 1;
                }
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }
}
