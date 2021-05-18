package cn.xiaohupao.leetcode12;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/18 12:03
 */
public class IntegerToRoman {

    /**
     * Roman numerals are represented by seven different symbols:I, V, X, L, C, D and M.
     * @param num int - integer
     * @return String - Roman numeral
     *
     * time: O(n)
     * space: O(n)
     */
    public static String intToRoman(int num){
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++){
            while (num >= values[i]){
                num -= values[i];
                sb.append(strs[i]);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }
}
