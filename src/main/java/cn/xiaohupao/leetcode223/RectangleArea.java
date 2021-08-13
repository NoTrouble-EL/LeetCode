package cn.xiaohupao.leetcode223;

/**
 * @Author: Wukun
 * @Date: 2021/8/13下午5:06
 */
public class RectangleArea {

    /**
     * Given the coordinates of two rectilinear rectangles in a 2D plane,
     * return the total area covered by the two rectangles.
     * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
     * The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).
     * @param ax1
     * @param ay1
     * @param ax2
     * @param ay2
     * @param bx1
     * @param by1
     * @param bx2
     * @param by2
     * @return
     *
     * time:O(1)
     * space:O(1)
     */
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // Calculate the area of the two rectangles
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        // Calculate the length and width of the common part
        int length = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int width = Math.min(ay2, by2) - Math.max(ay1, by1);

        // Area of overlap, Need to judge whether the length and width are less than or equal to 0,
        // if yes, it means no overlap
        int area3 = (length <= 0 || width <= 0) ? 0 : length * width;

        return area1 + area2 - area3;
    }

    public static void main(String[] args) {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
