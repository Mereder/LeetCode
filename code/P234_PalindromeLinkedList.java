/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.List;

public class P234_PalindromeLinkedList {
     public static class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
         }
     }
    public static boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

        }
        if(fast != null){
            slow = slow.next;
        }

        slow = reverse(slow);
        while(slow != null){
            if(slow.val != head.val){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }

        return true;

    }
    public static ListNode reverse(ListNode slow){
         if(slow == null ) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = slow;
        ListNode p = dummy.next;
        ListNode cur = p.next;
        while(cur != null){
            p.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        boolean result = isPalindrome(head);

    }
}
