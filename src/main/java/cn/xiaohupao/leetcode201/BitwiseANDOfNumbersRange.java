package cn.xiaohupao.leetcode201;

/**
 * @Author: Wukun
 * @Date: 2021/8/11下午3:57
 */
public class BitwiseANDOfNumbersRange {

    /**
     * Given two integers left and right that represent the range [left, right],
     * return the bitwise AND of all numbers in this range, inclusive.
     * @param left
     * @param right
     * @return
     */
    public static int rangeBitwiseAnd(int left, int right){
        //corner case
        if (left == 0){
            return 0;
        }

        //Create a variable to store two digits with the same prefix
        int count = 0;
        //Stop the loop when the two numbers are the same
        while (left != right){
            left >>= 1;
            right >>= 1;
            count++;
        }

        //The result is to move the common prefix to the left by count bits
        return left << count;
    }
}
