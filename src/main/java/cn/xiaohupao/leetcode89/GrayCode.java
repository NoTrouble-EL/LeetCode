package cn.xiaohupao.leetcode89;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/9 15:33
 */
public class GrayCode {

    /**
     * An n-bit gray code sequence is a sequence of 2n integers where:
     * Every integer is in the inclusive range [0, 2n - 1],
     * The first integer is 0,
     * An integer appears no more than once in the sequence,
     * The binary representation of every pair of adjacent integers differs by exactly one bit, and
     * The binary representation of the first and last integers differs by exactly one bit.
     * @param n integer n
     * @return any valid n-bit gray code sequence
     *
     * time: O(2^n)
     * space: O(1)
     */
    public static List<Integer> grayCode(int n){
        //Create a List to save the results
        List<Integer> res = new ArrayList<>();
        //Calculate the number of Gray codes generated
        int length = 1 << n;
        for (int i = 0; i < length; i++){
            //G(n) = n ^ (n/2)
            res.add(i ^ (i >> 1));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }
}
