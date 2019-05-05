/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import sun.reflect.generics.tree.Tree;

public class P108_ConvertSortedArraytoBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n <=0 )return  null;
        TreeNode root = helper(nums,0,n-1);

        return root;
    }

    public TreeNode helper(int[] nums,int lo,int hi){
        if (lo > hi ) return null;
        int mid = lo + ((hi-lo) >>1);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,lo,mid-1);
        node.right = helper(nums,mid+1,hi);

        return node;
    }
}
