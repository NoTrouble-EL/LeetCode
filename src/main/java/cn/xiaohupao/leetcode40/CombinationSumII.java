package cn.xiaohupao.leetcode40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/25 15:15
 */
public class CombinationSumII {

    /**
     * Given a collection of candidate numbers (candidates) and a target number (target),
     * find all unique combinations in candidates where the candidate numbers sum to target.
     * Each number in candidates may only be used once in the combination.
     * @param candidates an array of distinct integers candidates
     * @param target integer target
     * @return Each number in candidates may only be used once in the combination
     *
     * time: O(n*2^n)
     * space: O(n)
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return res;
        }

        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0);

        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start){
        if (target < 0){
            return;
        }
        if (target == 0){
            res.add(new ArrayList<>(list));
        }

        for (int i = start; i < candidates.length; i++){
            if (i != start && candidates[i] == candidates[i-1]){
                continue;
            }
            list.add(candidates[i]);
            helper(res, list, candidates, target-candidates[i], i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }
}
