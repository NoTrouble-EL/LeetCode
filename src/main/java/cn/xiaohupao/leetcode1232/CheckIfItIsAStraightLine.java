package cn.xiaohupao.leetcode1232;

/**
 * @Author: Wukun
 * @Date: 2021/8/13下午5:34
 */
public class CheckIfItIsAStraightLine {

    public static boolean checkStraightLine(int[][] coordinates){
        // corner case
        if (coordinates.length <= 2){
            return true;
        }

        // Calculate the increment of two points on the x-axis and y-axis
        int delX = coordinates[1][0] - coordinates[0][0];
        int delY = coordinates[1][1] - coordinates[0][1];

        // Traverse other points to determine whether the increment is proportional
        for (int i = 2; i < coordinates.length; i++){
            // Get the current increment on the x-axis and y-axis
            int newDelX = coordinates[i][0] - coordinates[0][0];
            int newDelY = coordinates[i][1] - coordinates[0][1];

            // Judging whether it is proportional, delY/delX = newDelY/newDelX
            if (delX * newDelY != delY * newDelX){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] coordinates = {
                {1,2},
                {2,3},
                {3,4},
                {4,5},
                {5,6},
                {6,7}
        };

        System.out.println(checkStraightLine(coordinates));
    }
}
