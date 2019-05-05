/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.List;

public class P147_InsertionSortList {
    public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode sortList = new ListNode(Integer.MIN_VALUE);
        ListNode p = head;
        while(head != null){
            p = head;
            head = head.next;
            p.next = null;
            if(sortList.next == null){
                sortList.next = p;
                continue;
            }
            ListNode q = sortList.next;
            if (q.val >= p.val){
                p.next = sortList.next;
                sortList.next = p;
                continue;
            }
            while(q != null){
                if (q.val < p.val && q.next == null){
                    q.next = p;
                    break;
                }
                if (q.val < p.val && q.next.val >= p.val){
                    p.next = q.next;
                    q.next = p;
                    break;
                }
                q = q.next;
            }
        }
        return sortList.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(3);

         insertionSortList(head);
    }
}
