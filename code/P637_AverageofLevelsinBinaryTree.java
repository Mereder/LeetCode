/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P637_AverageofLevelsinBinaryTree {
   public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int current = 1;
        int next = 0;
        long sum = 0;
        int num = current;
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            sum += p.val;
            current--;
            if(p.left!= null){
                queue.offer(p.left);
                next++;
            }
            if(p.right!=null){
                queue.offer(p.right);
                next++;
            }
            if(current == 0){
                double temp = sum / (num*1.0);
                result.add(temp);
                num = next;
                current = next;
                next = 0;
                sum = 0;
            }
        }
        return result;
    }
}
