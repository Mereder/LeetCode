### 题目描述

Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

**简而言之，查找二叉搜索树，找到返回以该值为根的树，找不到返回null**

For example, 

```
Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2
```

You should return this subtree:

```
      2     
     / \   
    1   3
```

In the example above, if we want to search the value `5`, since there is no node with value `5`, we should return `NULL`.

Note that an empty tree is represented by `NULL`, therefore you would see the expected output (serialized tree format) as `[]`, not `null`.

### 题解

没啥好说的，很简单的递归。依赖于二叉搜索的性质，左<根<右

```java
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(root.val < val) 
            return searchBST(root.right,val);
        if(root.val > val) 
            return searchBST(root.left,val);
        return null;
    }
```

