package cn.xiaohupao.leetcode01;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/15 22:41
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int sum = 0;
        while (l1 != null || l2 != null || sum != 0){
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            temp.next = new ListNode(sum % 10);
            sum /= 10;
            temp = temp.next;
        }

        return dummy.next;
    }

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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode temp1 = l1;
        for (int i = 0; i < 6; i++){
            temp1.next = new ListNode(9);
            temp1 = temp1.next;
        }
        ListNode l2 = new ListNode(9);
        temp1 = l2;
        for (int i = 0; i < 3; i++){
            temp1.next = new ListNode(9);
            temp1 = temp1.next;
        }
        temp1 = null;
        ListNode res = addTwoNumbers(l1,l2);
        System.out.println(res);
    }
}
