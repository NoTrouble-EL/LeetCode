package cn.xiaohupao.leetcode1290;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/20 15:12
 */
public class ConvertBinaryNumberInALinkedListToInteger {

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

    public static int getDecimalValue(ListNode head){
        int res = 0;
        while (head != null){
            res = (res * 2 + head.val);
            head = head.next;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        head.next = node1;
        node1.next = node2;

        System.out.println(getDecimalValue(head));
    }
}
