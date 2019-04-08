### 题目描述

Given a binary tree, find the leftmost value in the last row of the tree.

**Example 1:**

```
Input:

    2
   / \
  1   3

Output:
1
```

**Example 2:** 

```
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
```

**Note:** You may assume the tree (i.e., the given root node) is not **NULL**

### 解题思路

就一句话：**从右到左的层次遍历**

基础是层次遍历，但是基础层次遍历是  根出队，左入队，右入队。

这样我们的队列最后一个出队的  一定是一个**叶子结点**，而且是  叶子结点的 最右一个，

那么我们要求 最底下最左的 叶子结点，那么只需要入队顺序更改一下。

### 题解

```java
    public int findBottomLeftValue(TreeNode root) {
        // 这里队列的 初始化 是 LinkedList
        Queue<TreeNode> queue = new LinkedList<>();
    	// 入队  offer   出队  poll
        queue.offer(root);
        TreeNode node = root;
        while(!queue.isEmpty()){
            node = queue.poll();
            if (node.right != null){
                queue.offer(node.right);
            }
            if (node.left != null){
                queue.offer(node.left);
            }
        }
        return node.val;
    }
```