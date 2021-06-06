package cn.xiaohupao.leetcode78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/6 17:02
 */
public class Subsets {

    /**
     * Given an integer array nums of unique elements, return all possible subsets (the power set).
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     * @param nums an integer array
     * @return solution in any order
     *
     * time: O()
     * space: O()
     */
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        helper(res, new ArrayList<>(), nums, 0);

        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start){
        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++){
            list.add(nums[i]);
            helper(res, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        for (List<Integer> re : res){
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
