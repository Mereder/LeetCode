/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P24_SwapNodesinPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        ListNode q = head.next;
        ListNode tail = dummy;
        while(p!= null && q!=null){
            // swap
            p.next = q.next;
            q.next = p;
            tail.next = q;
            //
            tail = p;
            p = tail.next;
            if(p == null) break;
            q = p.next;
        }
        return dummy.next;
    }
}
