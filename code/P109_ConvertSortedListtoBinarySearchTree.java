/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P109_ConvertSortedListtoBinarySearchTree {
 public class ListNode {
     int val;
     ListNode next;

     ListNode(int x) {
         val = x;
     }
 }

 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode(int x) {
         val = x;
     }
 }
 // -10 -3 0 5 9
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head,ListNode tail){
        ListNode fast = head;
        ListNode slow = head;
        if (head == tail) return null;

        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head,slow);
        root.right = toBST(slow.next,tail);
        return root;
    }

    public static void main(String[] args) {
        P109_ConvertSortedListtoBinarySearchTree test = new P109_ConvertSortedListtoBinarySearchTree();
        List<Integer> a  = new LinkedList<>();

    }
}
