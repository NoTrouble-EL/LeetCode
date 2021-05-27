package cn.xiaohupao.leetcode46;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/27 14:22
 */
public class Permutations {

    /**
     * Given an array nums of distinct integers, return all the possible permutations.
     * You can return the answer in any order.
     * @param nums an array nums of distinct integers
     * @return all the possible permutations
     *
     * time: O(n*n!)
     * space: O(n)
     */
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        helper(res, new ArrayList<>(), nums);

        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }

        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
