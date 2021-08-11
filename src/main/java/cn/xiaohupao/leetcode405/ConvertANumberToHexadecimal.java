package cn.xiaohupao.leetcode405;

/**
 * @Author: Wukun
 * @Date: 2021/8/10下午5:29
 */
public class ConvertANumberToHexadecimal {

    public static String toHex(int num){
        //corner case
        if (num == 0){
            return "0";
        }

        //Create a StringBuilder to save the results
        StringBuilder res = new StringBuilder();

        //Traverse num from high to low, four bits as a group
        for (int i = 7; i >= 0; i--){
            int val = (num >> (4 * i)) & 0xf;

            if (res.length() > 0 || val > 0){
                char ch = hexChar(val);
                res.append(ch);
            }
        }

        return res.toString();
    }

    //Convert decimal numbers to hexadecimal characters
    private static char hexChar(int num){
        if (num < 10){
            return (char) ('0' + num);
        }

        return (char) (num - 10 + 'a');
    }

    public static void main(String[] args) {
        System.out.println(toHex(26));
    }
}
