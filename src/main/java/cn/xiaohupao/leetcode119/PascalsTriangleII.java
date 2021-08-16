package cn.xiaohupao.leetcode119;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wukun
 * @Date: 2021/8/16下午4:27
 */
public class PascalsTriangleII {

    /**
     * Given an integer rowIndex,
     * return the rowIndexth (0-indexed) row of the Pascal's triangle.
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex){
        // Create a List to save the results
        List<Integer> res = new ArrayList<>();
        res.add(1);

        // Recursive padding
        for (int i = 1; i <= rowIndex; i++){
            // C(m,n) = C(m-1,n) * (n-m+1) / m
            res.add((int)((long)res.get(i-1) * (rowIndex - i + 1) / i));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
