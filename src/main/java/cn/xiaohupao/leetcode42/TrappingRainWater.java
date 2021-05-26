package cn.xiaohupao.leetcode42;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/26 13:11
 */
public class TrappingRainWater {

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it can trap after raining.
     * @param height a non-negative integers
     * @return how much water it can trap after raining
     *
     * time: O(n)
     * space: O(1)
     */
    public static int trap(int[] height){
        int lo = 0, hi = height.length-1, loMax = 0, hiMax = 0;
        int res = 0;
        while (lo < hi){
            if (height[lo] < height[hi]){
                loMax = Math.max(loMax, height[lo]);
                res += loMax - height[lo];
                lo++;
            }else {
                hiMax = Math.max(hiMax, height[hi]);
                res += hiMax - height[hi];
                hi--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
