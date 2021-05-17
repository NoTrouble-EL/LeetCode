package cn.xiaohupao.leetcode06;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/17 11:48
 */
public class ZigZagConversion {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * @param s String
     * @param numRows int - number of rows
     * @return String - after convert
     *
     * time:
     * space:
     */
    public static String convert(String s, int numRows){
        if (numRows <= 1){
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++){
            sb[i] = new StringBuilder();
        }

        for(int i = 0; i < s.length(); i++){
            int index = i % (2 * numRows - 2);
            index = index < numRows ? index : (2 * numRows - 2 - index);
            sb[index].append(s.charAt(i));
        }

        for (int i = 1; i < sb.length; i++){
            sb[0].append(sb[i]);
        }

        return sb[0].toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }
}
