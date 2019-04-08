/*
 * Date :  2019.
 * Author : Mereder
 */

package code;


public class BalancedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    boolean isbalance = false;
    public boolean isBalanced(TreeNode root) {
        if (root == null ) { return true;}
        int depth = getDepth(root);
        return isbalance;
    }

    public int getDepth(TreeNode root){
        if (root == null) {
            return 0 ;
        }
        int  left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left-right) > 1){
            isbalance = false;
        }
        else isbalance = true;
        return Math.max(left,right) + 1;
    }
}
