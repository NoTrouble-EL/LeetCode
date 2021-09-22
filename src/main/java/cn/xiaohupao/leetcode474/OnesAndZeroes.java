package cn.xiaohupao.leetcode474;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/22 9:04
 */
public class OnesAndZeroes {

    public static int findMaxForm(String[] strs, int m, int n){
        //use dp
        int[][][] dp = new int[strs.length+1][m+1][n+1];

        //状态转移方程
        for (int i = 1; i <= strs.length; i++){
            //获取当前字符串中的0和1的个数
            int[] zerosAndOnes = getZerosAndOnes(strs[i-1]);
            int zeros = zerosAndOnes[0], ones = zerosAndOnes[1];
            for (int j = 0; j <= m; j++){
                for (int k = 0; k <= n; k++){
                    //dp[i][j][k]表示，使用0~i个字符串，最多j个0，最多k个1能够由最大dp[i][j][k]个子集组成
                    //在不使用第i个字符串时，最大的子集树为dp[i-1][j][k]
                    dp[i][j][k] = dp[i-1][j][k];
                    if (j >= zeros && k >= ones){
                        //在使用第i个字符串时，需要在当前0的个数小于j，1的个数小于k的情况下
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-zeros][k-ones] + 1);
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    private static int[] getZerosAndOnes(String str){
        int[] res = new int[2];
        for (char ch : str.toCharArray()){
            res[ch - '0']++;
        }

        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, 5,3));
    }
}
