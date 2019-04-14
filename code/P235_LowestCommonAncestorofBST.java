/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P235_LowestCommonAncestorofBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;

        if(p.val <= root.val && q.val >= root.val) return root;
        if(p.val >= root.val && q.val <= root.val) return root;
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return null;
    }
}
