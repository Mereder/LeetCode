### 题目描述

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

判断两个树是不是一样

**Example 1:**

```
Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
```

**Example 2:**

```
Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
```

**Example 3:**

```
Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
```

### 解题思路

递归判定同一位置的结点是否一致

逻辑撸清： 

1. 若两个树都null  return true

   if (p == null && q == null) return true;

2. 若一个树空一个树不空  return false （**注意这是基于第一个条件判否之后的**）

   if (p == null || q == null) return false;

   也就是说，这个if 只有p q 不一致才会 return

3. 经过上面判断  到这一步  肯定  p != null  q!=null

### 题解

```java
   public boolean isSameTree(TreeNode p,TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        // p q 肯定不null了
        if (p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
```

