package cn.xiaohupao.leetcode43;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/26 13:47
 */
public class MultiplyStrings {

    /**
     * Given two non-negative integers num1 and num2 represented as strings,
     * return the product of num1 and num2, also represented as a string.
     * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
     * @param num1 String num1
     * @param num2 String num2
     * @return the product of num1 and num2
     *
     * time: O(mn)
     * space: O(m+n)
     */
    public static String multiply(String num1, String num2){
        if (num1 == null || num2 == null){
            return "0";
        }

        int[] digits = new int[num1.length()+num2.length()];

        for (int i = num1.length()-1; i >= 0; i--){
            for (int j = num2.length()-1; j >= 0; j--){
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i+j, p2 = i+j+1;
                int sum = product + digits[p2];
                digits[p1] += sum / 10;
                digits[p2] = sum % 10;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int digit : digits){
            if (!(digit == 0 && res.length() == 0)){
                res.append(digit);
            }
        }

        return res.length() == 0 ? "0" : res.toString();
    }
    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        System.out.println(multiply(num1, num2));
    }
}
