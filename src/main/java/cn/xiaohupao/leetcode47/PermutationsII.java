package cn.xiaohupao.leetcode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/27 15:05
 */
public class PermutationsII {

    /**
     * Given a collection of numbers, nums, that might contain duplicates,
     * return all possible unique permutations in any order.
     * @param nums a collection of numbers that might contain duplicates
     * @return all possible unique permutations in any order
     *
     * time: O(n*n!)
     * space: O(n)
     */
    public static List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);

        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++){
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            helper(res, list, nums, used);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }
}
