/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P113_PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        findPath(root,result,stack,sum);

        return result;
    }

    public void findPath(TreeNode root,List<List<Integer>> result,Stack<TreeNode> stack,int sum){
        if(root == null) return;
        stack.push(root);
        int temp = sum - root.val;
        if(root.left == null && root.right==null && temp==0){
            List<Integer> cur = new ArrayList<>();
            for(TreeNode t:stack){
                cur.add(t.val);
            }
            result.add(cur);
        }
        if(root.left!=null)
            findPath(root.left,result,stack,temp);
        if(root.right!=null)
            findPath(root.right,result,stack,temp);

        stack.pop();
    }
}
