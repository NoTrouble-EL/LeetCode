package cn.xiaohupao.leetcode84;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/8 14:50
 */
public class LargestRectangleInHistogram {

    /**
     * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
     * return the area of the largest rectangle in the histogram.
     * @param heights an array of integers heights
     * @return largest rectangle in the histogram
     *
     * time: O(N)
     * space: O(N)
     */
    public static int largestRectangleArea(int[] heights){
        if (heights == null || heights.length == 0){
            return 0;
        }

        int N = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < N; i++){
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                res = Math.max(res, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1){
            res = Math.max(res, heights[stack.pop()] * (N - stack.peek() - 1));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
