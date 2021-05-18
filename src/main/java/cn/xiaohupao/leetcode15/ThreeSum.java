package cn.xiaohupao.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/18 14:18
 */
public class ThreeSum {

    /**
     * Given an integer array nums,
     * return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * @param nums Array
     * @return all the triplets
     *
     * time: O(n^2)
     * space: O(n)
     */
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int low = i+1, hi = nums.length-1, sum = 0 - nums[i];
            while (low < hi){
                if ((nums[low] + nums[hi]) == sum){
                    res.add(Arrays.asList(nums[i], nums[low], nums[hi]));
                    while (low < hi && nums[low] == nums[low+1]){
                        low++;
                    }
                    while (low < hi && nums[hi] == nums[hi-1]){
                        hi--;
                    }
                    low++;
                    hi--;
                }else if (nums[low] + nums[hi] < sum){
                    low++;
                }else{
                    hi--;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.print("[");
        for (int i = 0; i < lists.size(); i++){
            System.out.print(lists.get(i).toString());
        }
        System.out.println("]");
    }
}
