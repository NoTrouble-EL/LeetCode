package cn.xiaohupao.leetcode234;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/20 12:00
 */
public class PalindromeLinkedList {
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

    public static boolean isPalindrome(ListNode head){
        //corner case
        if (head == null || head.next == null){
            return true;
        }

        //将链表分为两部分，并翻转前一部分
        ListNode slow = head, fast = head, pre = null, cur = head;
        while (fast != null && fast.next != null){
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;
            cur.next = pre;
            pre = cur;
        }

        if (fast != null){
            slow = slow.next;
        }

        //比较是否回文
        while (cur != null && slow != null){
            if (cur.val != slow.val){
                return false;
            }
            cur = cur.next;
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(isPalindrome(head));
    }

}
