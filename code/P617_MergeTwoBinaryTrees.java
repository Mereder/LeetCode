/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P617_MergeTwoBinaryTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        TreeNode t = new TreeNode(0);
        t.val = t1.val+t2.val;
        if(t1.left != null || t2.left != null){
            t.left =  mergeTrees(t1.left,t2.left);
        }
        if (t1.right !=null || t2.right != null){
            t.right = mergeTrees(t1.right,t2.right);
        }
        return t;
    }
}
