package cn.xiaohupao.leetcode39;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/25 14:25
 */
public class CombinationSum {

    /**
     * Given an array of distinct integers candidates and a target integer target,
     * return a list of all unique combinations of candidates where the chosen numbers sum to target.
     * You may return the combinations in any order.
     * The same number may be chosen from candidates an unlimited number of times.
     * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
     * @param candidates an array of distinct integers candidates
     * @param target integer target
     * @return combinations in any order
     *
     * time: O()
     * space: O()
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return res;
        }
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
            list.add(candidates[i]);
            helper(res, list, candidates, target-candidates[i], i);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }
}
