/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

/*
* 前面加上一个 哑变量  dummy head
* */
public class ReverseLinkedList2 {

     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
 }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        int error = n-m;
        while( m-1 > 0){
            tail = tail.next;
            m--;
        }
        ListNode pr = tail.next;// 不能只指向  tail  tail指的结点还在head中。
        ListNode pc = pr.next;
        while(error > 0){
            pr.next = pc.next;
            pc.next = tail.next;
            tail.next = pc;
            pc = pr.next;
            error--;
        }
        return dummy.next;
    }
}
