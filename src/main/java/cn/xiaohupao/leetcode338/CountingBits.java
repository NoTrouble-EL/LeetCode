package cn.xiaohupao.leetcode338;

import java.util.Arrays;

/**
 * @Author: Wukun
 * @Date: 2021/8/11下午5:26
 */
public class CountingBits {

    /**
     * Given an integer n,
     * return an array ans of length n + 1 such that for each i (0 <= i <= n),
     * ans[i] is the number of 1's in the binary representation of i.
     * @param n
     * @return
     */
    public static int[] countBits(int n){
        //Create a dp array to save the results
        int[] dp = new int[n+1];

        //Create a variable to record an array with only 1 digit in the current number
        int bit = 0;
        for (int i = 1; i <= n; i++){
            //Determine whether the current number has only one digit as 1
            if ((i & (i-1)) == 0){
                bit = i;
            }
            //State transition equation
            dp[i] = dp[i - bit] + 1;
        }

        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }
}
