package cn.xiaohupao.leetcode29;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/22 13:41
 */
public class DivideTwoIntegers {

    /**
     * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
     *
     * @param dividend int - dividend
     * @param divisor int -  divisor
     * @return the quotient after dividing dividend by divisor.
     *
     * time: O(log(n))
     * space: O(log(n))
     */
    public static int divide(int dividend, int divisor){
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            sign = -1;
        }

        long ldividend = Math.abs((long) dividend), ldivisor = Math.abs((long) divisor);
        if (ldividend < ldivisor){
            return 0;
        }

        long lres = divide(ldividend, divisor);
        int res = 0;
        if (lres > Integer.MAX_VALUE){
            res = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else {
            res = sign == 1 ? (int) lres : (int) -lres;
        }

        return res;
    }

    private static long divide(long ldividend, long ldivisor){
        if (ldividend < ldivisor){
            return 0;
        }

        long sum = ldivisor, multipe = 1;
        while ((sum + sum) <= ldividend){
            sum += sum;
            multipe += multipe;
        }

        return multipe + divide(ldividend - sum, ldivisor);
    }
    public static void main(String[] args) {
        int dividend = 10, divisor = 3;
        System.out.println(divide(dividend, divisor));
    }
}
