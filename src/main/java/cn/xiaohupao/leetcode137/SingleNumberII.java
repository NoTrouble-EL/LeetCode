package cn.xiaohupao.leetcode137;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Wukun
 * @Date: 2021/8/12下午4:00
 */
public class SingleNumberII {

    /**
     * Given an integer array nums where every element appears three times except for one,
     * which appears exactly once. Find the single element and return it.
     * @param nums
     * @return
     *
     * time:O(n)
     * space:O(n)
     */
    public static int singleNumber(int[] nums){
        //Create a Map to record the number of occurrences of numbers
        Map<Integer, Integer> map = new HashMap<>();

        //Iterate over the array
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        // Iterate over the map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        System.out.println(singleNumber(nums));
    }
}
