package cn.xiaohupao.leetcode920;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/22 9:22
 */
public class NumberOfMusicPlaylists {

    final static int MOD = 1000000007;

    public static int numMusicPlaylists(int n, int goal, int k){
        // use dp
        int[][] dp = new int[goal+1][n+1];

        //init
        dp[0][0] = 1;

        //状态转移方程
        for (int i = 1; i <= goal; i++){
            for (int j = 1; j <= n; j++){
                //dp[i][j]表示播放列表长度为i，包含j首不同歌曲的数量
                //如果最后一首歌是未播放的，则有dp[i-1][j-1] * (n-j+1)种选择
                dp[i][j] += dp[i-1][j-1] * (n - j + 1);
                //如果是选择之前的歌，则有dp[i-1][j] * MAX(j-k,0)种选择
                dp[i][j] += dp[i-1][j] * Math.max(0, j-k);
                dp[i][j] %= MOD;
            }
        }

        return dp[goal][n];
    }

    public static void main(String[] args) {
        System.out.println(numMusicPlaylists(3,3,1));
    }
}
