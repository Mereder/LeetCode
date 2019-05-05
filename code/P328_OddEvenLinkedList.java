/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P328_OddEvenLinkedList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public static ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;

        while(even != null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(2);
//        head.next = new ListNode(1);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(5);
//        head.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(7);

        int[] test = {2,1,3,5,6,4,7};
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int i = 0; i < test.length; i++) {
            ListNode node = new ListNode(test[i]);
            p.next = node;
            p = p.next;
        }
        ListNode res  =  oddEvenList(head.next);
    }
}
