package cn.xiaohupao.leetcode59;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/31 18:11
 */
public class SpiralMatrixII {

    /**
     * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n^2 in spiral order.
     * @param n positive integer n
     * @return an n x n matrix filled with elements from 1 to n^2
     *
     * time: O(n^2)
     * space: O(1)
     */
    public static int[][] generateMatrix(int n){
        int[][] res = new int[n][n];
        int num = 1;
        int left = 0, right = n-1, top = 0, bottom = n-1;

        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++){
                res[top][i] = num;
                num++;
            }
            for (int i = top+1; i <= bottom; i++){
                res[i][right] = num;
                num++;
            }

            if (left < right && top < bottom){
                for (int i = right-1; i > left; i--){
                    res[bottom][i] = num;
                    num++;
                }
                for (int i = bottom; i > top; i--){
                    res[i][left] = num;
                    num++;
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return res;
    }

    public static void main(String[] args) {
        for (int[] re : generateMatrix(3)){
            System.out.println(Arrays.toString(re));
        }
    }
}
