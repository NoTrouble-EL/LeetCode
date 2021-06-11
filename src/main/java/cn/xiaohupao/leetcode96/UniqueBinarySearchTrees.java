package cn.xiaohupao.leetcode96;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/11 12:56
 */
public class UniqueBinarySearchTrees {

    /**
     * Given an integer n, return the number of structurally unique BST's (binary search trees)
     * which has exactly n nodes of unique values from 1 to n.
     * @param n an integer n
     * @return number of structurally unique BST
     *
     * time: O(n^2)
     * space: O(n)
     */
    public static int  numTrees(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-1-j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
