/*
 * Date :  2019.
 * Author : Mereder
 */

package code;


import java.util.LinkedList;
import java.util.Queue;

public class P513_findBottomLeftValue {
    public class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = root;
        while(!queue.isEmpty()){
            node = queue.poll();
            if (node.right != null){
                queue.offer(node.right);
            }
            if (node.left != null){
                queue.offer(node.left);
            }
        }
        return node.val;
    }
}
