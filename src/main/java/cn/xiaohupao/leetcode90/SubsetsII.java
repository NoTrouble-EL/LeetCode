package cn.xiaohupao.leetcode90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/9 16:11
 */
public class SubsetsII {

    /**
     * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     * @param nums an integer array nums
     * @return solution in any order
     *
     * time: O()
     * space: O()
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums){
        //backtracking
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        //排序数组用于后续的去重
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0, new boolean[nums.length]);

        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start, boolean[] used){
        res.add(new ArrayList<>(list));

        //横向遍历数组
        for (int i = start; i < nums.length; i++){
            //去重， 当前的数字等于前一个数字，且前一个数字没有使用
            if (i > 0 && nums[i-1] == nums[i] && !used[i-1]){
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            //递归
            helper(res, list, nums, i+1, used);
            //回溯
            used[i] = false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> res = subsetsWithDup(nums);
        for (List<Integer> r : res){
            System.out.println(Arrays.toString(r.toArray()));
        }
    }
}
