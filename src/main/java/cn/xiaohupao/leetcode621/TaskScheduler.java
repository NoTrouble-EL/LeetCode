package cn.xiaohupao.leetcode621;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/4 20:14
 */
public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n){
        //统计出每种任务出现的次数
        int[] count = new int[26];

        for (char ch : tasks){
            count[ch - 'A']++;
        }

        //取出出现任务最多的次数
        Arrays.sort(count);
        int maxTimes = count[25];

        //统计出和最多次数的任务
        int maxCount = 1;
        for (int i = 25; i > 0; i--){
            if (count[i] == count[i-1]){
                maxCount++;
            }else{
                break;
            }
        }

        int res = (n+1) * (maxTimes - 1) + maxCount;

        return Math.max(res, tasks.length);
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(tasks, 2));
    }
}
