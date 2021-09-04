package cn.xiaohupao.leetcode394;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/4 20:39
 */
public class DecodeString {

    public static String decodeString(String s){
        //创建两个栈，一个用于保存数字，一个用于保存StringBuilder

        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();

        //num用于记录数字的大小
        int num = 0;
        //str用于记录当前字符
        StringBuilder str = new StringBuilder();
        //遍历字符串
        for (char ch : s.toCharArray()){
            //若ch为数字则用num记录
            if (Character.isDigit(ch)){
                num = num * 10+ (ch - '0');
            }else if (ch == '['){
                //若ch为[则压入数组和StringBuilder
                numStack.push(num);
                strStack.push(str);
                num = 0;
                str = new StringBuilder();
            }else if (ch == ']'){
                //若为]则弹出数字和字符，并且重复
                int index = numStack.pop();
                StringBuilder cur = strStack.pop();

                for (int i = 0; i < index; i++){
                    cur.append(str);
                }
                str = cur;
            }else{
                str.append(ch);
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }
}
