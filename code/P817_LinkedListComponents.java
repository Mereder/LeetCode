/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.HashMap;

public class P817_LinkedListComponents {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static int numComponents(ListNode head, int[] G) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < G.length; i++) {
            hashMap.put(G[i], i);
        }
        ListNode p = head;
        int cnt = 0;
        boolean flag = false;
        while(p != null){
            if (hashMap.containsKey(p.val) && (p.next == null || !hashMap.containsKey(p.next.val) )){
                cnt++;
            }
            p = p.next;
        }
        return cnt;
    }

    public static void main(String[] args) {
//        head: 0->1->2->3
//        G = [0, 1, 3]
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        int []G = {0,3,1,4};
        System.out.println(numComponents(head,G));
    }
}
