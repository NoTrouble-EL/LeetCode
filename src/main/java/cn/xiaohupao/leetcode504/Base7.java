package cn.xiaohupao.leetcode504;

/**
 * @Author: Wukun
 * @Date: 2021/8/10下午4:05
 */
public class Base7 {

    /**
     * Given an integer num, return a string of its base 7 representation.
     * @param num integer num
     * @return string of 7 representation
     *
     * time:O( )
     * space:O()
     */
    public static String convertToBase7(int num){
        //Check if it is negative
        if (num < 0){
            return "-" + convertToBase7(-num);
        }

        //corner case
        if (num < 7){
            return ""+num;
        }

        //recur
        return convertToBase7(num / 7) + convertToBase7(num % 7);
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
    }
}
