package cn.xiaohupao.leetcode876;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/20 14:51
 */
public class MiddleOfTheLinkedList {

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

    public static ListNode middleNode(ListNode head){
        //使用快慢指针
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i < 7; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode res = middleNode(head);
    }
}
