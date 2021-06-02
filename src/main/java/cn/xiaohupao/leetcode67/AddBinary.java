package cn.xiaohupao.leetcode67;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/2 17:55
 */
public class AddBinary {

    /**
     * Given two binary strings a and b, return their sum as a binary string.
     * @param a binary String a
     * @param b binary String b
     * @return their sum as a binary string
     *
     * time: O(Max(a, b))
     * space: O(1)
     */
    public static String addBinary(String a, String b){
        int aLength = a.length()-1, bLength = b.length()-1;
        int sum = 0;
        StringBuilder res = new StringBuilder();
        while (aLength >= 0 || bLength >= 0 || sum > 0){
            if (aLength >= 0){
                sum += a.charAt(aLength--) - '0';
            }
            if (bLength >= 0){
                sum += b.charAt(bLength--) - '0';
            }
            res.append("" + sum % 2);
            sum /= 2;
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(addBinary(a, b));
    }
}
