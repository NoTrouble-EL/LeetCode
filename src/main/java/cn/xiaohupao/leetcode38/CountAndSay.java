package cn.xiaohupao.leetcode38;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/24 17:36
 */
public class CountAndSay {

    /**
     * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
     * countAndSay(1) = "1"
     * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
     * @param n int
     * @return String
     *
     * time: don't know
     * space: O(n)
     */
    public static String countAndSay(int n){
        int i = 1;
        String res = "1";
        while (i < n){
            int count = 0;
            StringBuilder sb = new StringBuilder();
            char c = res.charAt(0);
            for (int j = 0; j <= res.length(); j++){
                if (j != res.length() && res.charAt(j) == c){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(c);
                    if (j != res.length()){
                        count = 1;
                        c = res.charAt(j);
                    }
                }
            }

            res = sb.toString();
            i++;
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
