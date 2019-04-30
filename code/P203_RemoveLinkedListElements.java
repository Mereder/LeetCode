/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.List;

public class P203_RemoveLinkedListElements {
    public static class ListNode{
        public int val;
        ListNode next ;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = pre.next;
            }
            else{
                cur = cur.next;
                pre = pre.next;

            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        test.next = one;
        one.next = two;
        two.next = null;
        removeElements(test,3);
    }
}
