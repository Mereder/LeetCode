package code;

import java.util.List;

public class P160_IntersectionofTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;}
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode temp_A = headA;
        ListNode temp_B = headB;
        // 1. 计数
        while(temp_A.next != null){
            len1++;
            temp_A = temp_A.next;
        }
        while(temp_B.next != null){
            len2++;
            temp_B = temp_B.next;
        }

        if (len2  == 0 || len1 == 0) return null;
        // 2. 计算链表长度差
        int error = Math.abs(len1-len2);
        temp_A = headA;
        temp_B = headB;

        if (len1>len2){
            while(error > 0){
                temp_A = temp_A.next;
                error--;
            }
            while (temp_A != temp_B){
                temp_A = temp_A.next;
                temp_B = temp_B.next;
            }
            if (temp_A != null)
                return temp_A;
            else return null;
        }
        else {
            while(error > 0){
                temp_B = temp_B.next;
                error--;
            }
            while (temp_A != temp_B){
                temp_A = temp_A.next;
                temp_B = temp_B.next;
            }
            if (temp_B != null)
                return temp_B;
            else return null;
        }
    }

    public static void main(String[] args) {
        String test = "ABCD";
        System.out.println(test.toLowerCase());
        Character.isDigit('1');

    }
}
