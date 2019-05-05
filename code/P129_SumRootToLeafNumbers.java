/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import sun.reflect.generics.tree.Tree;

public class P129_SumRootToLeafNumbers {
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode(int x) {
              val = x;
          }
      }
    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        return helper(root,sum);
    }
    public static int helper(TreeNode root, int sum){
          if ( root == null) return 0;
          if (root.left == null && root.right == null)
              return sum*10+root.val;
          int left = helper(root.left,sum*10+root.val);
          int right = helper(root.right,sum*10+root.val);
          return left+right;
    }

    public static void main(String[] args) {
        int []nums = {4,9,0,5,1};
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        int res = sumNumbers(root   );
        System.out.println(res);
    }
}
