package cn.xiaohupao.leetcode143;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/19 21:21
 */
public class ReorderList {
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

    public static void reorderList(ListNode head){
        //corner case
        if (head == null || head.next == null){
            return;
        }

        //使用快慢指针将链表分成两半
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        temp = reverse(temp);

        while (temp != null){
            ListNode after = temp.next;
            temp.next = head.next;
            head.next = temp;
            head = temp.next;
            temp = after;
        }


    }

    private static ListNode reverse(ListNode head){
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


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i < 5; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        reorderList(head);
        System.out.println(head);
    }
}
