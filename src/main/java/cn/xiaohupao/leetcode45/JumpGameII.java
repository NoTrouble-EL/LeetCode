package cn.xiaohupao.leetcode45;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/26 16:16
 */
public class JumpGameII {

    /**
     * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Your goal is to reach the last index in the minimum number of jumps.
     * You can assume that you can always reach the last index.
     * @param nums integers nums
     * @return minimum number of jumps
     *
     * time: O(n)
     * space: O(1)
     */
    public static int jump(int[] nums){
        //corner case
        if (nums == null || nums.length < 2){
            return 0;
        }

        //定义一个变量用于保存结果
        int res = 0;
        //nextMax用于保存最大能到达的位置；curMax用于保存上一步能到达的最远距离
        int curMax = 0, nextMax = 0;
        //遍历数组
        for (int i = 0; i < nums.length - 1; i++){
            //每次遍历更新最大能到达的位置
            nextMax = Math.max(nextMax, i + nums[i]);
            //若当前位置为上一步到达的最远距离，则更新
            if (i == curMax){
                curMax = nextMax;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
