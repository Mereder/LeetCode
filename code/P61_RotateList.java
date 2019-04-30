/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P61_RotateList {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k <= 0) return head;
        int n = 0;
        ListNode p = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while(p != null){
            p = p.next;
            n++;
        }
        if(k >= n) k = k % n;
        while(k != 0){
            p = dummy.next;
            ListNode pre = dummy;
            while(p.next != null){
                p = p.next;
                pre = pre.next;
            }
            p.next = dummy.next;
            dummy.next = p;
            pre.next = null;
            k--;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        rotateRight(head,2);
    }
}
