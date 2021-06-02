package cn.xiaohupao.leetcode66;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/2 17:24
 */
public class PlusOne {

    /**
     * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
     * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
     * You may assume the integer does not contain any leading zero, except the number 0 itself.
     * @param digits Given a non-empty of decimal digits
     * @return decimal digits
     *
     * time: O(n)
     * space: O(1)
     */
    public static int[] plusOne(int[] digits){
        for (int i = digits.length-1; i >= 0; i--){
            if (digits[i] != 9){
                digits[i] += 1;
                return digits;
            }else{
                digits[i] = 0;
            }
        }

        int[] res = new int[digits.length+1];
        res[0] = 1;

        return res;
    }
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
