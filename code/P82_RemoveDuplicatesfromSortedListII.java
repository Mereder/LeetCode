/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P82_RemoveDuplicatesfromSortedListII {
      public static class ListNode {
          int val;
          ListNode next;

          ListNode(int x) {
              val = x;
          }
      }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode p = head;
        int temp;
        while(p.next != null){
            if(p.val == p.next.val){
                temp = p.val;
                while(p!=null && p.val == temp  ){
                    p = p.next;
                }
                tail.next = p;
                if(p == null) break;
            }
            else{
                tail.next = p;
                tail = tail.next;
                p = p.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(4);
        deleteDuplicates(head);

    }
}
