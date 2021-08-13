package cn.xiaohupao.leetcode50;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/28 13:48
 */
public class PowXN {

    /**
     * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     * @param x Base
     * @param n Exponent
     * @return calculates x raised to the power n
     *
     * time: O(log(n))
     * space: O(log(n))
     */
    public static double myPow(double x, int n){
        // corner case
        if (n == 0){
            return -1;
        }

        long N = n;

        return N > 0 ? pow(x, N) : (1.0 / pow(x, -N));
    }

    public static double pow(double x, long n){
        // Recursive exit
        if (n == 0){
            return 1;
        }

        double y = pow(x, (n >> 1));

        return n % 2 == 0 ? y * y : y * y * x;
    }


    public static void main(String[] args) {
        double x = 2.0;
        int n = -2;
        System.out.println(myPow(x, n));
    }
}
