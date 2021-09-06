package cn.xiaohupao.leetcode547;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/4 20:56
 */
public class NumberOfProvinces {

    public static int findCircleNum(int[][] isConnected){
        //使用深度优先搜索

        //创建一个数组用于记录已经记录的城市
        boolean[] used = new boolean[isConnected.length];

        int res = 0;

        //遍历行
        for(int i = 0; i < isConnected.length; i++){
            //每次访问没有访问过的城市
            if (!used[i]){
                //找到所有和i相邻的城市
                dfs(isConnected, used, i);
                //一趟dfs找到所有的与i相邻的城市
                res++;
            }
        }

        return res;
    }

    //深度优先
    private static void dfs(int[][] isConnected, boolean[] used, int i){
        for (int j = 0; j < isConnected.length; j++){
            //如果城市ij相邻，且城市j未访问，则从城市j继续访问
            if (isConnected[i][j] == 1 && !used[j]){
                used[j] = true;
                dfs(isConnected, used, j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        System.out.println(findCircleNum(isConnected));
    }
}
