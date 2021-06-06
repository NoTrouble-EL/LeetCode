package cn.xiaohupao.leetcode77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/6 16:06
 */
public class Combinations {

    /**
     * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
     * You may return the answer in any order.
     * @param n integer n
     * @param k k numbers out of the range[1,n]
     * @return answer in any order
     *
     * time: O()
     * space: O()
     */
    public static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0){
            return res;
        }
        helper(res, new ArrayList<>(), n, k , 1);

        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int start){
        if (list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n - (k - list.size()) + 1; i++){
            list.add(i);
            helper(res, list, n, k ,i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 2);
        for (List<Integer> r : res){
            System.out.println(Arrays.toString(r.toArray()));
        }
    }
}
