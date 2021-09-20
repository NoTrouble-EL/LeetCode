package cn.xiaohupao.leetcode328;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/20 13:20
 */
public class OddEvenLinkedList {

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

    public static ListNode oddEvenList(ListNode head){
        //corner case
        if (head == null || head.next == null){
            return head;
        }

        //交替
        ListNode temp = head, newHead = head.next, temp1 = newHead;

        while (temp1 != null && temp1.next != null){
            temp.next = temp1.next;
            temp = temp.next;
            temp1.next = temp.next;
            temp1 = temp1.next;
        }

        temp.next = newHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i < 6; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode res = oddEvenList(head);
    }
}
