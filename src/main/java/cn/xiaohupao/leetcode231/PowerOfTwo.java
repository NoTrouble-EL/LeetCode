package cn.xiaohupao.leetcode231;

/**
 * @Author: Wukun
 * @Date: 2021/8/13上午9:26
 */
public class PowerOfTwo {

    /**
     * Given an integer n, return true if it is a power of two. Otherwise, return false.
     * An integer n is a power of two, if there exists an integer x such that n == 2^x.
     * @param n
     * @return
     *
     * time:O(1)
     * space:O(1)
     */
    public static boolean isPowerOfTwo(int n){
        // A power of 2 binary contains only one 1
        // Must be greater than 0
        return n > 0 && ((n & (n-1))) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
    }
}
