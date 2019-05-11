/*
 * Date :  2019.
 * Author : Mereder
 */

package code;



import java.util.ArrayList;
import java.util.List;

public class P95_UniqueBinarySearchTreesII {
      public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
    public List<TreeNode> generateTrees(int n) {
          if (n == 0) return new ArrayList<>();
        return helper(1,n);
    }
    public List<TreeNode> helper(int start,int end){
          List<TreeNode> result = new ArrayList<>();

          if (start > end   ){
              result.add(null);
              return result;
          }
          if (start == end){
              result.add(new TreeNode(start));
              return result;
          }
          // 左侧 右侧 结点的list
          List<TreeNode> left,right;
          for (int i = start; i <= end ; i++) {
            left = helper(start,i-1);
            right = helper(i+1,end);

              for (TreeNode lnode:left
                   ) {
                  for (TreeNode rnode: right
                       ) {
                      TreeNode root = new TreeNode(i);
                      root.left = lnode;
                      root.right = rnode;
                      result.add(root);
                  }
              }
          }
          return result;
    }
}
