/*
 * Date :  2019.
 * Author : Mereder
 */

package code;
// tag: LinkedList

import java.util.ArrayList;
import java.util.Stack;

public class P1019_NextGreaterNodeInLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public static int[] nextLargerNodes(ListNode head) {
        if (head == null ) return null;
        int n = 0;
        ListNode p = head;
        while(p != null){
            p = p.next;
            n++;
        }
        if (n == 0 ) return null;
        int []result = new int[n];
        ListNode tail = head;
        int i = 0;
        while(tail != null){
            int max = 0;
            p = tail;
            while(p != null){
                if (p.val > tail.val){
                    max = p.val;
                    break;
                }
                p=p.next;
            }
            result[i] = max;
            i++;
            tail = tail.next;
        }
        return result;
    }

    public int[] nextLargerNodes1(ListNode head) {
        ArrayList<Integer> A = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            A.add(node.val);
        int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
                res[stack.pop()] = A.get(i);
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
