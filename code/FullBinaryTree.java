/*
 * Date :  2019.
 * Author : Mereder
 */

package code;


import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//
public class FullBinaryTree {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean isCompleteBTree(TreeNode root){
         if(root == null) return false;
        Queue<TreeNode>  queue = new LinkedList<>();
        queue.offer(root);
        boolean LEAF = false;
        while(!queue.isEmpty()) {
            TreeNode preNode = queue.poll();
            if (preNode.left == null && preNode.right != null) {
                return false;
            }
            // 因为是层次遍历  所以考虑 进入叶子结点模式 同一层都应该
            if (LEAF &&
                    (preNode.left != null) || (preNode.right != null)) {
                return false;
            }

            if (preNode.left != null) {
                queue.offer(preNode.left);
            }
            // 左不空 右可以空
            if (preNode.right != null) {
                queue.offer(preNode.right);
            } // 这个else 包含上边过滤过来的信息  left right都空
            else {
                LEAF = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        System.out.println(isCompleteBTree(root));
    }

}
