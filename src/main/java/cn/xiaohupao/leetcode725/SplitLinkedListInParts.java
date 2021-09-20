package cn.xiaohupao.leetcode725;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/20 14:14
 */
public class SplitLinkedListInParts {

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

    public static ListNode[] splitListToParts(ListNode head, int k){
        //计算出链表中元素的个数
        int size = 0;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            size++;
        }

        //分配个数组中的个数
        int si = size / k;
        //前几个数组中分配的个数需要+1
        int index = size % k;

        ListNode[] res = new ListNode[k];

        //给数组初始化
        for (int i = 0; i < k && head != null; i++){
            res[i] = head;
            int rsize = si + ((index-- > 0) ? 1 : 0);
            for (int j = 0; j < rsize - 1; j++){
                head = head.next;
            }
            ListNode after = head.next;
            head.next = null;
            head = after;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i < 11; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode[] listNodes = splitListToParts(head, 3);

    }
}
