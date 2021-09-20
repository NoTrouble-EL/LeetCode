package cn.xiaohupao.leetcode206;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/20 11:35
 */
public class ReverseLinkedList {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this(val);
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head){
        //corner case
        if (head == null || head.next == null){
            return head;
        }

        ListNode pre = null, cur = head;
        while (cur != null){
            ListNode after = cur.next;
            cur.next = pre;
            pre = cur;
            cur = after;
        }

        return pre;
    }

    public static ListNode reverseList1(ListNode head){
        //corner case
        if (head == null || head.next == null){
            return head;
        }

        ListNode after = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return after;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i < 6; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode res1 = reverseList(head);
        ListNode res2 = reverseList1(head);
    }
}
