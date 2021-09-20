package cn.xiaohupao.leetcode203;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/20 11:28
 */
public class RemoveLinkedListElements {
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

    public static ListNode removeElements(ListNode head, int val){
        //构建一个dummy节点，使用双指针
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, temp = head;
        while (temp != null){
            if (temp.val == val){
                pre.next = temp.next;
            }else{
                pre = temp;
            }
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode res = removeElements(head, 6);
    }
}
