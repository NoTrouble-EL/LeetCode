package cn.xiaohupao.leetcode739;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/4 19:24
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures){
        //使用单调栈
        //在栈中存储索引位置
        Deque<Integer> stack = new ArrayDeque<>();

        //创建一个数组用于保存结果
        int[] res = new int[temperatures.length];

        //遍历数组
        for(int i = 0; i < temperatures.length; i++){
            //单调栈，若栈顶元素小于当前的值，则弹出一个索引，并更新res
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}