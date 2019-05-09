/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102_BinaryTreeLevelOrderTraversal {
   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;

       TreeNode(int x) {
           val = x;
       }
   }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int current = 1;
        int next = 0;
        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            temp.add(p.val);
            current--;
            if(p.left != null){
                queue.offer(p.left);
                next++;
            }
            if(p.right != null){
                queue.offer(p.right);
                next++;
            }
            if(current == 0){
                result.add(temp);
                temp = new ArrayList<>();
                current = next;
                next = 0;
            }
        }
        return result;
    }
}
