package cn.xiaohupao.leetcode326;

/**
 * @Author: Wukun
 * @Date: 2021/8/13上午9:47
 */
public class PowerOfThree {

    /**
     * Given an integer n, return true if it is a power of three. Otherwise, return false.
     * An integer n is a power of three, if there exists an integer x such that n == 3x.
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n){
        // corner case
        if (n < 1){
            return false;
        }

        // Cycle to determine whether it can divide 3
        while (n % 3 == 0){
            n /= 3;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(9));
    }
}
