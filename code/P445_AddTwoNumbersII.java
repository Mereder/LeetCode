/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.List;
import java.util.Stack;

public class P445_AddTwoNumbersII {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode p = l1;
        while(p != null){
            stack1.push(p);
            p =p .next;
        }
        p =  l2;
        while(p != null){
            stack2.push(p);
            p = p.next;
        }
        ListNode dummy = new ListNode(-1);
        int add = 0;
        int sum = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if (!stack1.isEmpty()) sum+= stack1.pop().val;
            if (!stack2.isEmpty()) sum+= stack2.pop().val;
            if (sum >= 10){
                if (!stack1.isEmpty()){
                    stack1.peek().val += sum /10;
                }
                else {
                    stack1.push(new ListNode(sum/10));
                }
            }
            ListNode node = new ListNode(sum % 10);
            node.next = dummy.next;
            dummy.next = node;
            sum = 0;
        }
        return  dummy.next;
    }
    // 糟糕的方案
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        long num1 = 0;
        long num2 = 0;
        ListNode p = l1;
        while(p != null){
            num1 = num1*10 + p.val;
            p =p .next;
        }
        p =  l2;
        while(p != null){
            num2 = num2*10 + p.val;
            p = p.next;
        }
        int max = Integer.MIN_VALUE;
        long sum = num1 + num2;
        ListNode dummy = new ListNode(-1);
        if (sum == 0) return new ListNode(0);
        while(sum != 0){
            ListNode node = new ListNode( 10);
            node.next = dummy.next;
            dummy.next = node;
            sum = sum/10;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
//        Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 8 -> 0 -> 7
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
//        head.next.next = new ListNode(4);
//        head.next.next.next = new ListNode(3);

        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(6);
//        l1.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(head,l1);
    }
}
