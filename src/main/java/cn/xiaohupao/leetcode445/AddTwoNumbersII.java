package cn.xiaohupao.leetcode445;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/20 13:28
 */
public class AddTwoNumbersII {

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        //翻转两个链表
        ListNode reverse1 = reverse(l1);
        ListNode reverse2 = reverse(l2);

        //求和
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int sum = 0;
        while (reverse1 != null || reverse2 != null || sum != 0){
            if (reverse1 != null){
                sum += reverse1.val;
                reverse1 = reverse1.next;
            }
            if (reverse2 != null){
                sum += reverse2.val;
                reverse2 = reverse2.next;
            }
            temp.next = new ListNode(sum % 10);
            sum /= 10;
            temp = temp.next;
        }

        //再翻转
        return reverse(dummy.next);
    }

    private static ListNode reverse(ListNode head){
        //corner case
        if (head == null || head.next == null){
            return head;
        }

        ListNode after = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return after;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        l1.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode l2 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);
        l2.next = node4;
        node4.next = node5;

        ListNode res = addTwoNumbers(l1, l2);
    }
}
