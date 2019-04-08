/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class isSymmetric {
    public class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int value){
            this.val = value;
        }
    }
    public boolean isSymmetric(TreeNode root) {

        if(root.left == null || root.right == null )
            return root.left == root.right;
        return isSymmetric(root.left,root.right);

    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val) return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}
