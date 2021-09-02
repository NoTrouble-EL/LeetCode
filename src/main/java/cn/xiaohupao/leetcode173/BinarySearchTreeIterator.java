package cn.xiaohupao.leetcode173;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Wukun
 * @Date: 2021/9/2下午2:26
 */
public class BinarySearchTreeIterator {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class BSTIterator{

        private static TreeNode cur;
        private static Deque<TreeNode> stack;

        public BSTIterator(TreeNode root){
            cur = root;
            stack = new ArrayDeque<>();
        }

        public static int next(){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            int res = node.val;
            cur = node.right;

            return res;
        }

        public static boolean hasNext(){
            return cur != null || !stack.isEmpty();
        }
    }
}
