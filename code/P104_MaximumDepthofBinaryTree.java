/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P104_MaximumDepthofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int left  = maxDepth(root.left);
        int right = maxDepth(root.right);

        if (left >= right )
            return left+1;
        else {
            return  right+1;
        }
    }
}
