package cn.xiaohupao.leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/19 18:09
 */
public class FourSum {

    /**
     * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
     * 0 <= a, b, c, d < n
     * a, b, c, and d are distinct.
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * @param nums Array
     * @param target target value
     * @return an array of all the unique quadruplets
     *
     * time: O(n^3)
     * space: O(n)
     */
    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4){
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length; j++){
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int lo = j+1, hi = nums.length-1;
                while (lo < hi){
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]){
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi-1]){
                            hi--;
                        }
                        lo++;
                        hi--;
                    }else if (sum < target){
                        lo++;
                    }else{
                        hi--;
                    }
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
}
