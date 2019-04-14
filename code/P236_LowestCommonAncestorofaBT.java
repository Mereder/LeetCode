/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P236_LowestCommonAncestorofaBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ) return null;
        if(root == p || root == q) return root;
        if(root.left == p && root.right == q) return root;
        if(root.left == q && root.right == p) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null) return root;
        if(left !=null) return left;
        if(right != null) return right;
        return null;
    }
}
