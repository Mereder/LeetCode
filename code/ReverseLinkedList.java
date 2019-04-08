/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

/*
就地逆置
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode temp = head;
        ListNode pre = head;
        ListNode current = pre.next;
        while(current != null){
            pre.next = current.next;
            current.next = temp;
            temp = current;
            current = pre.next;
        }
        return temp;
    }
}
