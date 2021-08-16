package cn.xiaohupao.leetcode204;

import java.util.Arrays;

/**
 * @Author: Wukun
 * @Date: 2021/8/16下午2:55
 */
public class CountPrimes {

    /**
     * Count the number of prime numbers less than a non-negative number, n.
     * @param n
     * @return
     *
     * time:O(nlog(log(n)))
     * space:O(n)
     */
    public static int countPrimes(int n){
        // Elbow sieve
        // Create an array to mark whether it is a prime number
        int[] isPrimes = new int[n];

        // Initial value
        Arrays.fill(isPrimes, 1);

        // Create an invariant to store the result
        int res = 0;

     //Start traversing from the smallest prime number 2
        for (int i = 2; i < n; i++){
            if (isPrimes[i] == 1){
                res++;
                if ((long) i * i < n){
                    for (int j = i * i; j < n; j += i){
                        isPrimes[j] = 0;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
