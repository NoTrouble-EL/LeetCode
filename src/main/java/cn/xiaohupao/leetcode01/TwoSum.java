package cn.xiaohupao.leetcode01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/15 19:56
 */
public class TwoSum{

    /**
     * Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
     * @param nums Array
     * @param target target value
     * @return index
     *
     * time：O(n)
     * space：O(n)
     */
    public static int[] twoSum(int[] nums, int target){
        //corner case
        if (nums == null || nums.length < 2){
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
