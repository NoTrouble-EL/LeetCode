package cn.xiaohupao.leetcode56;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/31 16:13
 */
public class MergeIntervals {

    /**
     * Given an array of intervals where intervals[i] = [starti, endi],
     * merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     * @param intervals an array of intervals
     * @return merge all overlapping intervals
     *
     * time: O(nlog(n))
     * space: O(log(n))
     */
    public static int[][] merge(int[][] intervals){
        ArrayList<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length < 2){
            return intervals;
        }
        Arrays.sort(intervals, (a, b)->a[0] - b[0]);
        for (int[] interval : intervals){
            if (res.size() == 0 || res.get(res.size()-1)[1] < interval[0]){
                res.add(interval);
            }else{
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], interval[1]);
            }
        }

        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        for (int[] res : merge(intervals)){
            System.out.println(Arrays.toString(res));
        }
    }
}
