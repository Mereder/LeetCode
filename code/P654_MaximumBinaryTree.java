/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P654_MaximumBinaryTree {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        //   1.找最大
        int n = nums.length;
        if (n <= 0) return null;
        return helper(nums,n,0,n-1);
    }

    public TreeNode helper(int[] nums,int n,int lo,int hi){
         if (lo > hi) return null;
         if (lo == hi) return new TreeNode(nums[lo]);
         //  找最大， 找到后
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = lo; i <= hi; i++) {
            if (max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        //  [3,2,1,6,0,5]
        TreeNode root=  new TreeNode(max);
        root.left = helper(nums,index,lo,index-1);
        root.right = helper(nums,n-index-1,index+1,hi);
        return root;
    }

    public static void main(String[] args) {
        int [] nums = {3,2,1,6,0,5};
        P654_MaximumBinaryTree test = new P654_MaximumBinaryTree();
        test.constructMaximumBinaryTree(nums);
    }

}
