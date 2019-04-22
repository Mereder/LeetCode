/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P144_BinaryTreePreorderTraversal {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> list = new LinkedList<>();
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp.val);

        }
        return list;
    }
}
