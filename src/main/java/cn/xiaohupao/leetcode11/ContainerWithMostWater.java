package cn.xiaohupao.leetcode11;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/18 11:20
 */
public class ContainerWithMostWater {

    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
     * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
     * @param height Array
     * @return int - max area
     *
     * time: O(n)
     * space: O(1)
     */
    public static int maxArea(int[] height){
        // two point
        int res = 0, i = 0, j = height.length - 1;

        while (i < j){
            res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
