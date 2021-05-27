package cn.xiaohupao.leetcode48;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/27 15:31
 */
public class RotateImage {

    /**
     * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
     * DO NOT allocate another 2D matrix and do the rotation.
     * @param matrix 2D matrix
     *
     * time: O(n^2)
     * space: O(1)
     */
    public static void rotate(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = i+1; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < (matrix[0].length >> 1); j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        for (int[] ma : matrix){
            System.out.println(Arrays.toString(ma));
        }
        System.out.println("-------------");
        rotate(matrix);
        for (int[] ma : matrix){
            System.out.println(Arrays.toString(ma));
        }
    }
}
