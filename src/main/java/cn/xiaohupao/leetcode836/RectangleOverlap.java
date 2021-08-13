package cn.xiaohupao.leetcode836;

/**
 * @Author: Wukun
 * @Date: 2021/8/13上午11:34
 */
public class RectangleOverlap {

    /**
     * An axis-aligned rectangle is represented as a list [x1, y1, x2, y2],
     * where (x1, y1) is the coordinate of its bottom-left corner,
     * and (x2, y2) is the coordinate of its top-right corner.
     * Its top and bottom edges are parallel to the X-axis,
     * and its left and right edges are parallel to the Y-axis.
     *
     * Two rectangles overlap if the area of their intersection is positive.
     * To be clear, two rectangles that only touch at the corner or edges do not overlap.
     *
     * Given two axis-aligned rectangles rec1 and rec2,
     * return true if they overlap, otherwise return false.
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2){
        // The area of both rectangles is greater than 0
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3]
        || rec2[0] == rec2[2] || rec2[1] == rec2[3]){
            return false;
        }

        // The projection on the x-axis and the projection on the y-axis need to coincide
        return (rec2[0] < rec1[2] && rec2[2] > rec1[0]) &&
                (rec2[1] < rec1[3] && rec2[3] > rec1[1]);
    }

    public static void main(String[] args) {
        int[] rec1 = {0,0,2,2}, rec2 = {1,1,3,3};
        System.out.println(isRectangleOverlap(rec1, rec2));
    }
}
