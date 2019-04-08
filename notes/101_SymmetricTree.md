### 题目描述

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree `[1,2,2,3,4,4,3]` is symmetric:

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```



But the following `[1,2,2,null,3,null,3]` is not:

```
    1
   / \
  2   2
   \   \
   3    3
```



**Note:**
Bonus points if you could solve it both recursively and iteratively.

### 解题思路

（...往往能想到正确思路 然后 细想就不知道怎么搞了）

##### 递归

递归的话，就是递归判断root 的左右子树是否为 对称，但是当时想的就在一个函数上递归解决，后来发现，不可以，所以只能再写一个函数，专门来进行递归。其实判断是否对称的过程 就是 判断是否相等的过程，只不过这个相等 是需要看好 结点位置的。

对于这个对称来说，left = right 而下一层 就需要

```java
 left.left == right.rifht  && left.right = right.left
```

(单对一棵子树分析，比如left  实际上就是实现了left的 前序遍历先取left的值与right比较   再 left.left  然后 left.right  单对right分析也是如此，只不过遍历顺序是先右再左)

##### 非递归

借助栈来实现，同时压栈 同时出栈，注意压栈和出栈顺序即可。

（还没实现  实现了就贴上来）

### 题解

##### 递归

```java
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null || root.right == null )
            return root.left == root.right;
        return isSymmetric(root.left,root.right);

    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val) return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
```

##### 非递归

```sql

```

