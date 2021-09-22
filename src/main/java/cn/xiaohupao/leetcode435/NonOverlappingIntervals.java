package cn.xiaohupao.leetcode435;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/22 8:55
 */
public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals){
        //corner case
        if (intervals == null || intervals.length == 0){
            return 0;
        }

        //Sort
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);

        int count = 1;
        int val = intervals[0][1];

        for (int i = 1; i < intervals.length; i++){
            if (val <= intervals[i][0]){
                count++;
                val = intervals[i][1];
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
