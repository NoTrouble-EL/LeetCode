package cn.xiaohupao.leetcode1561;

import java.util.Arrays;

/**
 * @Author: Wukun
 * @Date: 2021/8/16下午5:35
 */
public class MaximumNumberOfCoinsYouCanGet {

    /**
     * There are 3n piles of coins of varying size,
     * you and your friends will take piles of coins as follows:
     *
     * In each step, you will choose any 3 piles of coins (not necessarily consecutive).
     * Of your choice, Alice will pick the pile with the maximum number of coins.
     * You will pick the next pile with maximum number of coins.
     * Your friend Bob will pick the last pile.
     * Repeat until there are no more piles of coins.
     *
     * Given an array of integers piles where piles[i] is the number of coins in the ith pile.
     * @param piles
     * @return the maximum number of coins which you can have
     */
    public static int maxCoins(int[] piles){
        // Sort
        Arrays.sort(piles);

        // Create a variable to save the result
        int res = 0;

        // Index taken for the first time
        int index = piles.length-2;

        // Traverse
        for (int i = 1; i <= piles.length / 3; i++){
            // The value taken each time is the largest two numbers and the smallest one
            res += piles[index];
            index -= 2;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] piles = {2,4,1,2,7,8};
        System.out.println(maxCoins(piles));
    }
}
