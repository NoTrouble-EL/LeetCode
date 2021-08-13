package cn.xiaohupao.leetcode190;

/**
 * @Author: Wukun
 * @Date: 2021/8/11下午2:46
 */
public class ReverseBits {

    /**
     * Reverse bits of a given 32 bits unsigned integer.
     * @param n
     * @return
     *
     * time:O(1)
     * space:O(1)
     */
    public static int reverseBits(int n){
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);

        return n;
    }

    public static void main(String[] args) {
        int input = 43261596;
        System.out.println(Integer.toBinaryString(input));
        System.out.println(Integer.toBinaryString(reverseBits(43261596)));
    }
}
