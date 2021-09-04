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

    //backtracking
    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums){
        //递归出口，当集合的大小等于数组长度
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }

        //横向遍历
        for (int num : nums) {
            //排除已经遍历的数字
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            //纵向遍历
            helper(res, list, nums);
            //回溯
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
