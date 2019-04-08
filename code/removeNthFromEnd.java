/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class removeNthFromEnd {
    public class ListNode{
        int val;
        ListNode next = null;
        ListNode(int value){
            this.val = value;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return null;

        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = temp;
        while (fast != null){
            fast = fast.next;
            n--;
            if (n == 0){
                break;
            }
        }
        if (n > 0 ) return null;
        while (fast != null ){
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = slow.next;
        return temp.next;
    }
}
