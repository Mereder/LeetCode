/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P876_MiddleoftheLinkedList {
     public static class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
         }
     }
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode p = head;
        int n = 0;
        while(p != null){
            n++;
            p = p.next;
        }
        n = n/2;
        ListNode fast = head;
        ListNode slow = head;
        while(n > 0){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        P876_MiddleoftheLinkedList test = new P876_MiddleoftheLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        test.middleNode(head);

    }
}
