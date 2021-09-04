package cn.xiaohupao.leetcode179;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/4 20:23
 */
public class LargestNumber {

    public static String largestNumber(int[] nums){
        //将数组转为字符串数组，然后将其排序，排序到规则为前后两个数组合的逆序排序

        String[] str = new String[nums.length];

        for (int i = 0; i < nums.length; i++){
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (a,b) -> (b+a).compareTo(a+b));

        //使用StringBuilder来保存数组
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length; i++){
            res.append(str[i]);
        }

        return res.charAt(0) == '0' ? "0" : res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
