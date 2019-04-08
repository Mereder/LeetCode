package code;

import java.util.List;

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        int sum = 0;
        ListNode p = temp;
        while (l1 != null || l2 != null || sum !=0){
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null ){
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum%10);
            sum /= 10;
            p = p.next;
        }
        return  temp.next;
    }

}
