package cn.xiaohupao.leetcode342;

/**
 * @Author: Wukun
 * @Date: 2021/8/13上午10:00
 */
public class PowerOfFour {

    /**
     * Given an integer n, return true if it is a power of four. Otherwise, return false.
     * An integer n is a power of four, if there exists an integer x such that n == 4^x.
     * @param n
     * @return
     *
     * time:O(1)
     * space:O(1)
     */
    public static boolean isPowerOfFour(int n){
        // Satisfaction is a power of 2, and the result of mod 3 is 1
        return (n & (n - 1)) == 0 && n % 3 == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }
}
