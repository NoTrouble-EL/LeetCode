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
        //corner case
        if (candidates == null || candidates.length == 0){
            return res;
        }
        //sort
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0);

        return res;
    }

    //backtracking
    private static void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start){
        //corner case
        if (target < 0){
            return;
        }
        //目标值为0则直接加入结果
        if (target == 0){
            res.add(new ArrayList<>(list));
        }

        //横向遍历
        for (int i = start; i < candidates.length; i++){
            //去重
            if (i != start && candidates[i] == candidates[i-1]){
                continue;
            }
            list.add(candidates[i]);
            //递归
            helper(res, list, candidates, target-candidates[i], i+1);
            //回溯
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }
}
