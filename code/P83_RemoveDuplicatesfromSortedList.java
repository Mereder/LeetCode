/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P83_RemoveDuplicatesfromSortedList {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode p = head;
        while(p.next != null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }
            else{
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode result = deleteDuplicates(head);
    }
}
