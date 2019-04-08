/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class UnivaluedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
    public boolean isUnivalTree(TreeNode root) {
        if (root.left != null){
            if (!isUnivalTree(root.left) ) return false;
            if (root.left.val != root.val) return false;
        }

        if (root.right != null){
            if(!isUnivalTree(root.right)) return false;
            if(root.right.val != root.val) return false;
        }
        return true;
    }
}
