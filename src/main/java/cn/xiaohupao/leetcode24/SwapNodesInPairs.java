package cn.xiaohupao.leetcode24;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/20 15:54
 */
public class SwapNodesInPairs {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
     * @param head - linked list
     * @return ListNode - swap every two adjacent nodes
     *
     * time: O(n)
     * space: O(n)
     */
    public static ListNode swapPairs(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode newNode = head.next;
        head.next = swapPairs(newNode.next);
        newNode.next = head;

        return newNode;
    }

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
     * @param head - linked list
     * @return ListNode - swap every two adjacent nodes
     *
     * time: O(n)
     * space: O(1)
     */
    public static ListNode swapPairs1(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;

        while (l2 != null && l2.next != null){
            ListNode nextStart = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = nextStart;
            l1 = l2;
            l2 = l2.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i < 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode res = swapPairs(head);
        System.out.println(res);

        ListNode res1 = swapPairs1(res);
        System.out.println(res1);
    }
}
