package cn.xiaohupao.leetcode57;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/31 16:54
 */
public class InsertInterval {

    /**
     * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
     * You may assume that the intervals were initially sorted according to their start times.
     * @param intervals a set of non-overlapping intervals
     * @param newInterval a new interval
     * @return merge all overlapping intervals
     *
     * time: O(n)
     * space: O(1)
     */
    public static int[][] insert(int[][] intervals, int[] newInterval){
        ArrayList<int[]> res = new ArrayList<>();
        int index = 0;
        for (int[] interval : intervals){
            if (interval[0] < newInterval[0]){
                res.add(interval);
            }else {
                break;
            }
        }

        if (res.size() == 0 || res.get(res.size()-1)[1] < newInterval[0]){
            res.add(newInterval);
        }else{
            res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], newInterval[1]);
        }

        for (int i = index; i < intervals.length; i++){
            if (res.get(res.size()-1)[1] < intervals[i][0]){
                res.add(intervals[i]);
            }else {
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], intervals[i][1]);
            }
        }

        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2, 5};
        for (int[] res : insert(intervals, newInterval)){
            System.out.println(Arrays.toString(res));
        }
    }
}
