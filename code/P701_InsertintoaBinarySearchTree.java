/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P701_InsertintoaBinarySearchTree {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null ) return null;
        if(root.val > val ){
            if(root.left==null)
                root.left = new TreeNode(val);
            else
                root.left = insertIntoBST(root.left,val);
        }
        if(root.val < val){
            if(root.right == null)
                root.right = new TreeNode(val);
            else
                root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}
