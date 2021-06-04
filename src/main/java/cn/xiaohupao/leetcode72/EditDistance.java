package cn.xiaohupao.leetcode72;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/4 14:04
 */
public class EditDistance {

    /**
     * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
     * You have the following three operations permitted on a word:
     * Insert a character
     * Delete a character
     * Replace a character
     * @param word1 a character
     * @param word2 a character
     * @return minimum number of operations required to convert word1 to word2
     *
     * time: O(mxn)
     * space: O(mxn)
     */
    public static int minDistance(String word1, String word2){
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++){
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++){
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }
}
