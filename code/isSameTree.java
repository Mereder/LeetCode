/*
 * Date :  2019.
 * Author : Mereder
 */

package code;


public class isSameTree {
    public class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int values){
            this.val = values;
        }
    }

    public boolean isSameTree(TreeNode p,TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        // p q 肯定不null了
        if (p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}
