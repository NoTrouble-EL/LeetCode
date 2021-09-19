package cn.xiaohupao.leetcode19;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/19 19:00
 */
public class RemoveNthNodeFromEndOfList {
    public static class ListNode{
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
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     * @param head head of a linked list
     * @param n int - end of the list
     * @return ListNode - end of the list listNode
     *
     * time: O(n)
     * space: O(1)
     */
    public static ListNode removeNthNodeFromOfList(ListNode head, int n){
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = head;

        for (int i = 0; i < n; i++){
            fast = fast.next;
        }

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i < 6; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode res = removeNthNodeFromOfList(head, 2);
        System.out.println(res);
    }
}
