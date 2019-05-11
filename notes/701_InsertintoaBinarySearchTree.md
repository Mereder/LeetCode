题目链接：[701. Insert into a Binary Search Tree](<https://leetcode.com/problems/insert-into-a-binary-search-tree/>)

### 题目描述

Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

简而言之：向二叉搜索树中插入某个结点，可以保证的是新值肯定不在树中。

For example, 

```
Given the tree:
        4
       / \
      2   7
     / \
    1   3
And the value to insert: 5
```

You can return this binary search tree:

```
         4
       /   \
      2     7
     / \   /
    1   3 5
```

This tree is also valid:

```
         5
       /   \
      2     7
     / \   
    1   3
         \
          4
```

### 题解

题目很简单，就是二叉搜索树的查找过程。这里需要加的一个判断就是 如果  新值比根的值小，且根无左结点，则插入左侧，若有左结点 则递归操作左结点。右侧同理。

```java
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null ) return null;
        if(root.val > val ){
            if(root.left==null)
                root.left = new TreeNode(val);
            else
                root.left = insertIntoBST(root.left,val);
        }
        if(root.val < val){
            if(root.right == null)
                root.right = new TreeNode(val);
            else
                root.right = insertIntoBST(root.right,val);
        }
        return root;
        
    }
```



