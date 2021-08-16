package cn.xiaohupao.leetcode118;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wukun
 * @Date: 2021/8/16下午3:54
 */
public class PascalsTriangle {

    /**
     * Given an integer numRows,
     * return the first numRows of Pascal's triangle.
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows){
        // Create a list collection to store the array
        List<List<Integer>> res = new ArrayList<>();

        // Traversal fill
        for (int i = 0; i < numRows; i++){
            // Create a List collection
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++){
                // The first and last of each line is 1
                if (j == 0 || j == i){
                    list.add(1);
                }else{
                    // The value in other positions is the value of the
                    // previous position + the previous value of the previous position
                    list.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
                }
            }

            res.add(list);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
