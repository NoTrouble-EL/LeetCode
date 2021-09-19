package cn.xiaohupao.leetcode23;


/**
 * @Author: xiaohupao
 * @Date: 2021/5/20 15:14
 */
public class MergeKSortedLists {

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

    /**
     *You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     * Merge all the linked-lists into one sorted linked-list and return it.
     * @param lists linked-lists
     * @return Merge all the linked-lists into one sorted linked-list
     *
     * time: O(nlogk)
     * space: O(n)
     */
    public static ListNode mergeKLists(ListNode[] lists){
        //思路为使用归并排序
        if (lists == null || lists.length == 0){
            return null;
        }
        return sort(lists, 0, lists.length - 1);
    }

    private static ListNode sort(ListNode[] lists, int lo ,int hi){
        //corner case
        if (lo >= hi){
            return lists[lo];
        }

        //找中间值
        int mid = ((hi - lo) >> 1) + lo;
        //递归排序左边
        ListNode l1 = sort(lists, lo, mid);
        //递归排序右边
        ListNode l2 = sort(lists, mid+1, hi);

        //merge
        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        if (l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];

        ListNode l1 = new ListNode(1);
        ListNode temp = l1;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        temp = l2;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        temp = l3;
        temp.next = new ListNode(6);

        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        ListNode res = mergeKLists(lists);
        System.out.println(res);
    }
}
