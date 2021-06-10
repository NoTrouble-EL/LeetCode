package cn.xiaohupao.leetcode93;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/10 20:33
 */
public class RestoreIPAddress {

    /**
     * Given a string s containing only digits, return all possible valid IP addresses
     * that can be obtained from s. You can return them in any order.
     * A valid IP address consists of exactly four integers,
     * each integer is between 0 and 255, separated by single dots and cannot have leading zeros.
     * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245",
     * "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
     * @param s a string s containing only digits
     * @return any order IP
     */
    public static List<String> restoreIpAddress(String s){
        List<String> res = new ArrayList<>();
        if (s.length() > 12){
            return res;
        }
        helper(res, s, 0, 0);

        return res;
    }

    private static void helper(List<String> res, String s, int index, int numPoint){
        if (numPoint == 3){
            if (isValid(s, index, s.length()-1)){
                res.add(s);
            }
            return;
        }

        for (int i = index; i < s.length(); i++){
            if (isValid(s, index, i)){
                s = s.substring(0, i+1) + "." + s.substring(i+1);
                numPoint++;
                helper(res, s, i+2, numPoint);
                numPoint--;
                s = s.substring(0, i+1) + s.substring(i+2);
            }else {
                break;
            }
        }
    }

    private static boolean isValid(String s, int start, int end){
        if (start > end){
            return false;
        }
        if (s.charAt(start) == '0' && start != end){
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++){
            if (s.charAt(i) > '9' || s.charAt(i) < '0'){
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String s = "101023";
        List<String> list = restoreIpAddress(s);
        System.out.println(list);
    }
}
