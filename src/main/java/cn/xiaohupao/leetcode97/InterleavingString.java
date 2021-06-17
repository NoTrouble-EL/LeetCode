package cn.xiaohupao.leetcode97;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/17 20:54
 */
public class InterleavingString {

    /**
     * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
     * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
     * Note: a + b is the concatenation of strings a and b.
     * @param s1 string
     * @param s2 string
     * @param s3 string
     * @return true is ....
     *
     * time:O(nm)
     * space:O(nm)
     */
    public static boolean isInterleave(String s1, String s2, String s3){
        int n = s1.length(), m = s2.length();
        if (n+m != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for (int i = 1; i <= n && s1.charAt(i-1) == s3.charAt(i-1); i++){
            dp[i][0] = true;
        }
        for (int i = 1; i <= m && s2.charAt(i-1) == s3.charAt(i-1); i++){
            dp[0][i] = true;
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
                        (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
