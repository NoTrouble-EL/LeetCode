package cn.xiaohupao.leetcode62;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/1 16:25
 */
public class UniquePaths {

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * How many possible unique paths are there?
     * @param m width
     * @param n length
     * @return possible unique paths are there
     *
     * time: O(m)
     * space: O(1)
     */
    public static int uniquePaths(int m, int n){
        long res = 1;
        for (int i = n, j = 1; j < m; i++, j++){
            res =  res * i / j;
        }

        return (int) res;
    }
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
