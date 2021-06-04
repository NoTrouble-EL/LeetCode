package cn.xiaohupao.leetcode74;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/4 16:20
 */
public class SearchA2DMatrix {

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * @param matrix an m x n matrix
     * @param target target number
     * @return true is the searches for target in an matrix
     *
     * time: O(log(mn))
     * space: O(1)
     */
    public static boolean searchMatrix(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0){
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi){
            int mid = ((hi - lo) >> 1) + lo;
            if (target == matrix[mid/n][mid%n]){
                return true;
            }else if(target < matrix[mid/n][mid%n]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
}
