package cn.xiaohupao.leetcode593;

import java.util.Arrays;

/**
 * @Author: Wukun
 * @Date: 2021/8/16上午11:44
 */
public class ValidSquare {

    /**
     * Given the coordinates of four points in 2D space p1, p2, p3 and p4,
     * return true if the four points construct a square.
     * The coordinate of a point pi is represented as [xi, yi].
     * The input is not given in any order.
     * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     * @return
     */
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4){
        // Determine whether the four points overlap
        if(p1[0] == p2[0] && p1[1] == p2[1]){
            return false;
        }
        if(p1[0] == p3[0] && p1[1] == p3[1]){
            return false;
        }
        if(p1[0] == p4[0] && p1[1] == p4[1]){
            return false;
        }
        if(p2[0] == p3[0] && p2[1] == p3[1]){
            return false;
        }
        if(p2[0] == p4[0] && p2[1] == p4[1]){
            return false;
        }
        if(p3[0] == p4[0] && p3[1] == p4[1]){
            return false;
        }

        // Calculate the square of the distance
        int[] dis = new int[6];
        dis[0] = computerDis(p1, p2);
        dis[1] = computerDis(p1, p3);
        dis[2] = computerDis(p1, p4);
        dis[3] = computerDis(p2, p3);
        dis[4] = computerDis(p2, p4);
        dis[5] = computerDis(p3, p4);

        // Sort
        Arrays.sort(dis);

        // Test the relationship of distance
        if (dis[0] != dis[1] || dis[1] != dis[2] || dis[2] != dis[3]){
            return  false;
        }else if (dis[4] != dis[5]){
            return false;
        }

        return true;
    }

    private static int computerDis(int[] p, int[] q){
        return ((p[0] - q[0]) * (p[0] - q[0])) + ((p[1] - q[1]) * (p[1] - q[1]));
    }

    public static void main(String[] args) {
        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};
        System.out.println(validSquare(p1, p2, p3, p4));
    }
}
