package cn.xiaohupao.leetcode974;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/5 19:45
 */
public class SubarraySumsDivisibleByK {

    /**
     * Given an integer array nums and an integer k,
     * return the number of non-empty subarrays that have a sum divisible by k.
     * @param nums
     * @param k
     * @return
     */
    public static int subarraysDivByK(int[] nums, int k){
        //使用前缀和
        //同余定理 P[j] - P[i-1] MOD k == 0 -> P[j] mod k == P[i-1] mod k
        //创建一个map用于记录相同余数的数量
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int n : nums){
            sum += n;
            while (sum < 0){
                sum += k;
            }
            int mod = sum % k;
            int same = map.getOrDefault(mod, 0);
            res += same;
            map.put(mod, same+1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(A, 5));
    }
}
