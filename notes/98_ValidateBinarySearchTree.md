题目链接：[98. Validate Binary Search Tree](<https://leetcode.com/problems/validate-binary-search-tree/submissions/>)

### 题目描述

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

- The left subtree of a node contains only nodes with keys **less than** the node's key.
- The right subtree of a node contains only nodes with keys **greater than**the node's key.
- Both the left and right subtrees must also be binary search trees.

**Example 1:**

```
    2
   / \
  1   3

Input: [2,1,3]
Output: true
```

**Example 2:**

```
    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
```

### 解题思路

方案一（错误）:

思路是，判断一个二叉树是不是二叉搜索树，只需要根大于左子树且小于右子树，然后再依次判断左右子树是二叉搜索树即可。但是这个思路没有考虑到 根节点和子树的子树比较。如下情况，满足  1<5<6 且左右子树都是二叉搜索树，但是 5> 3 。就不可以了。

```
    5
   / \
  1   6
     / \
    3   7
```

方案二（时间效率低 ）：

既然二叉搜索树是：左<根<右，那么必然存在树的中序遍历是完全递增序列。

1. 中序遍历
2. 判断遍历结果是否是单调递增的。

方案三：

​	方案二实际上遍历了两次，一次树的中序遍历，一次对数组的遍历。方案三就直接使用了一次。方案三的思想也比较新颖：二叉搜索树是有序的且所有的值都处于min~max之间。以方案一中的案例来说明，这个二叉搜索树的所有值应该是1<=x<=7，那么对于左子树其条件就是:1<=x< root，对于右子树，就是  root<x<=7。显然右子树中出现了（3<6<7）这个组合肯定不成立。

### 题解

方案一的实现，是错误的，错误原因分析见上

```java
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left!=null){
            if(root.val <= root.left.val) return false;
            if(!isValidBST(root.left)) return false;
        }
        if(root.right!=null){
            if(root.val >= root.right.val) return false;
            if(!isValidBST(root.right)) return false;
        }
        return true;
    }
```

方案二

先中序遍历 再 判断序列单调

```java
public boolean isValidBST(TreeNode root) {
    List<Integer> inorder = new ArrayList<>();
    inorder(root,inorder);
    for (int i = 1; i < inorder.size(); i++) {
        if (inorder.get(i) <= inorder.get(i-1)){
            return false;
        }
    }
    return true;
}
public void inorder(TreeNode root,List<Integer> res){
   if (root == null) return;
   inorder(root.left,res);
   res.add(root.val);
   inorder(root.right,res);
}
```

方案三

```java
public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
    	//  核心思想：逐步判断  搜索树的范围，如果在该范围内出现了不属于该范围的数 false
        return isValidBST(root.left, minVal, root.val) && 
            		isValidBST(root.right, root.val, maxVal);
    }
```





