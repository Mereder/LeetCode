/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P112_PathSum {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left==null && root.right==null && sum== root.val) return true;
        int temp = sum-root.val;

        return hasPathSum(root.left,temp) || hasPathSum(root.right,temp);
    }
}
