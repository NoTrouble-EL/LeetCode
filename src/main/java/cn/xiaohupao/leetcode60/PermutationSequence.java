package cn.xiaohupao.leetcode60;

import java.util.ArrayList;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/31 19:56
 */
public class PermutationSequence {

    /**
     * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
     * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * Given n and k, return the kth permutation sequence.
     * @param n total number
     * @param k kth
     * @return kth permutation sequence
     *
     * time: O(n)
     * space: O(n)
     */
    public static String getPermutation(int n, int k){
        int[] f = new int[n];
        f[0] = 1;
        //use dp 记录n个元素有多少种排列方式
        for (int i = 1; i < n; i++){
            f[i] = i * f[i-1];
        }

        //use List记录n个可用的数字
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            list.add(i);
        }

        k--;
        StringBuilder res = new StringBuilder();
        for (int i = n-1; i >= 0; i--){
            int index = k / f[i];
            res.append(list.get(index));
            list.remove(index);
            k %= f[i];
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }
}
