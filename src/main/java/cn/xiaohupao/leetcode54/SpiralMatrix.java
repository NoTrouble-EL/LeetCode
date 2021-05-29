package cn.xiaohupao.leetcode54;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/29 20:19
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length-1, top = 0, bottom = matrix.length-1;
        while(left <= right && top <= bottom){
            for (int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            for (int i = top+1; i <= bottom; i++){
                res.add(matrix[i][right]);
            }

            if (left < right && top < bottom){
                for (int i = right-1; i > left; i--){
                    res.add(matrix[bottom][i]);
                }
                for (int i = bottom; i > top; i--){
                    res.add(matrix[i][left]);
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
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}
