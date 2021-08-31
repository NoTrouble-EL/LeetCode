package cn.xiaohupao.leetcode109;

/**
 * @Author: xiaohupao
 * @Date: 2021/8/31 15:52
 */
public class ConvertSortedListToBinarySearchTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * Given the head of a singly linked list where elements are sorted in ascending order,
     * convert it to a height balanced BST.
     *
     * For this problem,
     * a height-balanced binary tree is defined as a binary tree
     * in which the depth of the two subtrees of every node never differ by more than 1.
     * @param head
     * @return
     */
    public static TreeNode sortedListToBST(ListNode head){
        return helper(head, null);
    }

    private static TreeNode helper(ListNode start, ListNode end){
        //corner case
        if (start == end){
            return null;
        }

        ListNode midNode = getMidNode(start, end);
        //构建root节点
        TreeNode root = new TreeNode(midNode.val);
        //递归构建左子树
        root.left = helper(start, midNode);
        //构建右子树
        root.right = helper(midNode.next, end);

        return root;
    }

    private static ListNode getMidNode(ListNode start, ListNode end){
        //使用快慢指针
        ListNode fast = start, slow = start;

        while (fast != end && fast.next != end){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode node1 = new ListNode(-3);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        TreeNode res = sortedListToBST(head);
        System.out.println(res);
    }
}
