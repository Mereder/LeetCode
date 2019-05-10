/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.ArrayList;
import java.util.List;

public class P98_ValidateBinarySearchTree {
   public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root,inorder);
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i-1)){
                return false;
            }
        }
        return true;
    }
    public void inorder(TreeNode root,List<Integer> res){
       if (root == null) return;
       inorder(root.left,res);
       res.add(root.val);
       inorder(root.right,res);
    }

    public boolean best_isValidBST(TreeNode root){
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root,long left,long right){
        if (root == null) return  true;
        if (root.val<=left || root.val >= right) return false;
        return helper(root.left,left,root.val) && helper(root.right,root.val,right);
    }
    public static void main(String[] args) {
        P98_ValidateBinarySearchTree test = new P98_ValidateBinarySearchTree();

    }
}
