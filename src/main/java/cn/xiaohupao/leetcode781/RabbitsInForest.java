package cn.xiaohupao.leetcode781;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/4 19:16
 */
public class RabbitsInForest {

    /**
     * There is a forest with an unknown number of rabbits.
     * We asked n rabbits "How many rabbits have the same color as you?"
     * and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.
     *
     * Given the array answers, return the minimum number of rabbits that could be in the forest.
     * @param answers
     * @return
     */
    public static int numRabbits(int[] answers){
        //统计出回答相同的次数
        Map<Integer, Integer> map = new HashMap<>();

        for (int an : answers){
            map.put(an, map.getOrDefault(an, 0)+1);
        }

        int res = 0;

        //遍历map集合
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int x = entry.getKey(), y = entry.getValue();
            res += (x+y)/(x+1) * (x+1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] answers = {1,1,2};
        System.out.println(numRabbits(answers));
    }
}
