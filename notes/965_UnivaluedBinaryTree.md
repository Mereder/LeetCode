### 题目描述

A binary tree is *univalued* if every node in the tree has the same value.

Return `true` if and only if the given tree is univalued.

 **简而言之** 问树的所有值是不是唯一的。

**Example 1:**

```
Input: [1,1,1,1,1,null,1]
Output: true
```

**Example 2:**

```
Input: [2,2,2,5,2]
Output: false
```

**Note:**

1. The number of nodes in the given tree will be in the range `[1, 100]`.
2. Each node's value will be an integer in the range `[0, 99]`.

### 解题思路

只要是树的一种遍历方式，就能解决这个问题，只要中间出现了不等的情况那么就不是值唯一的二叉树。

另外一种思想：解决树问题惯用的，一个二叉树是否满足某个性质，就是看根满足的情况下，左右子树是否也满足。这就构成了一个递归思路。把左右子树再看成二叉树去判断。

### 题解

```java
public boolean isUnivalTree(TreeNode root) {
    // 左子树：如果根和左不等 直接false 否则递归判断左子树
   if (root.left != null){
       if (root.left.val != root.val) return false;
       if (!isUnivalTree(root.left) ) return false;
       
   }
    // 右子树：同上
   if (root.right != null){
       if(root.right.val != root.val) return false;
       if(!isUnivalTree(root.right)) return false;

   }
    // 左右都是null 就直接true。
    return true;
}
```

