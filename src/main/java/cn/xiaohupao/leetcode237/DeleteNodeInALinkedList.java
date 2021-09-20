package cn.xiaohupao.leetcode237;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/20 13:12
 */
public class DeleteNodeInALinkedList {

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

    public static void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node = new ListNode(5);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(9);
        head.next = node;
        node.next = node1;
        node1.next = node2;

        deleteNode(node);

    }
}
