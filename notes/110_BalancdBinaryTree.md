### 题目描述

Given a binary tree, determine if it is height-balanced. For this problem, a height-balanced binary tree is defined as:

> a binary tree in which the depth of the two subtrees of *every* node never differ by more than 1.

即 ：左右两个子树的高度差不能超过1；（<=1）

**Example 1:**

Given the following tree `[3,9,20,null,null,15,7]`:

```
    3
   / \
  9  20
    /  \
   15   7
```

Return true.

**Example 2:**

Given the following tree `[1,2,2,3,3,null,null,4,4]`:

```
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```

Return false.

### 解题思路

**有点小trick吧：树的问题归结起来都是 左子树 右子树 左子树 右子树，是一种很适合递归处理的数据结构**

题目很简单，在求树深的基础上，加上一个判断  左右子树高度差 <=1；



### 题解

```java
    boolean isbalance = true;
    public boolean isBalanced(TreeNode root) {
        int depth = getDepth(root);
        return isbalance;
    }
	// 递归求树深 
    public int getDepth(TreeNode root){
        if (root == null) {
            return 0 ;
        }
        int  left = getDepth(root.left);
        int right = getDepth(root.right);
        // 格外加一个判断
        if (Math.abs(left-right) > 1){
            isbalance = false;
        }
        return Math.max(left,right) + 1;
    }
```

