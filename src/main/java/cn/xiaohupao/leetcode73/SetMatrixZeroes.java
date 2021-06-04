package cn.xiaohupao.leetcode73;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/4 14:47
 */
public class SetMatrixZeroes {

    /**
     * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
     * Follow up:
     * A straight forward solution using O(mn) space is probably a bad idea.
     * A simple improvement uses O(m + n) space, but still not the best solution.
     * Could you devise a constant space solution?
     * @param matrix an m x n matrix
     * time: O(mn)
     * space: O(1)
     */
    public static void setZeroes(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        boolean row = false, col = false;

        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                row = true;
                break;
            }
        }

        for (int i = 0; i < n; i++){
            if (matrix[0][i] == 0){
                col = true;
                break;
            }
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if (row){
            for (int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }

        if (col){
            for (int i = 0; i < n; i++){
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix);
        for (int[] ma : matrix) {
            System.out.println(Arrays.toString(ma));
        }
    }
}
