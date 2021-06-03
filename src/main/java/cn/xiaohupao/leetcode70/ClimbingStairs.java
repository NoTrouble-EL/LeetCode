package cn.xiaohupao.leetcode70;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/3 14:08
 */
public class ClimbingStairs {

    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * @param n steps to reach the top
     * @return how many distinct ways to the top
     *
     * time: O(n)
     * space: O(1)
     */
    public static int climbStairs(int n){
        int q = 0, p = 0, r = 1;
        for (int i = 1; i <= n; i++){
            q = p;
            p = r;
            r = q+p;
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
