/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.List;

public class P148_SortList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode p = null;
        while(fast != null && fast.next != null){
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        p.next = null;
        // 这个地方注意
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return mergeLists(left,right);
    }

    public ListNode mergeLists(ListNode l1, ListNode l2){
        ListNode temp = new ListNode(-1);
        ListNode p = temp;
        while(l1 != null && l2 !=null){
            if (l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }
            else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if( l2 != null) p.next = l2;
        return temp.next;
    }

    public static void main(String[] args) {
        P148_SortList test = new P148_SortList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode temp = test.sortList(head);
    }
}
