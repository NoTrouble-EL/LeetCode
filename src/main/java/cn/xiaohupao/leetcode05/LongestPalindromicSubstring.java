package cn.xiaohupao.leetcode05;


/**
 * @Author: xiaohupao
 * @Date: 2021/5/16 21:16
 */
public class LongestPalindromicSubstring {
    /**
     * Given a string s, return the longest palindromic substring in s.
     * @param s String
     * @return String - longestPalindrome
     *
     * dp
     *
     * time: O(n^2)
     * space: O(n^2)
     */
    public static String longestPalindrome1(String s){
        if (s == null || s.length() == 0){
            return s;
        }

        int N = s.length(), max = 0;
        String res = "";
        boolean[][] dp = new boolean[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j <= i; j++){
                dp[j][i] = ((s.charAt(j) == s.charAt(i)) && (i - j <= 2 || dp[j+1][i-1]));
                if (dp[j][i]){
                    if (i - j + 1 > max){
                        max = (i - j + 1);
                        res = s.substring(j, i+1);
                    }
                }
            }
        }
        return res;
    }

    private static String res = "";

    /**
     * Given a string s, return the longest palindromic substring in s.
     * @param s String
     * @return String - longestPalindrome
     *
     * 中心扩散法
     *
     * time: O(n^2)
     * space: O(1)
     */
    public static String longestPalindrome2(String s){
        if (s == null || s.length() == 0){
            return s;
        }
        int N = s.length();
        for (int i = 0; i < N; i++){
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return res;
    }
    private static void helper(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        String cur = s.substring(left+1, right);
        if (cur.length() > res.length()){
            res = cur;
        }
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome1(s));
        System.out.println(longestPalindrome2(s));
    }
}
