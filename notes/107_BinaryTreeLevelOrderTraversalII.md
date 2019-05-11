题目链接：[Binary Tree Level Order Traversal II]<https://leetcode.com/problems/binary-tree-level-order-traversal-ii/>

### 题目描述

Given a binary tree, return the *bottom-up level order* traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

层次倒序输出....新瓶子装旧药

For example:
Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

return its bottom-up level order traversal as:

```
[
  [15,7],
  [9,20],
  [3]
]
```

### 解题思路

主要思路参考:[剑指Offer——将二叉树打印成多行](https://www.jianshu.com/p/50ed487ebbc0)

需要更改的地方，每一层加入到最终的result 时候，将新产生的List从头部加入，这样result中的结果就是倒序的层次遍历了。

### 题解

```java
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
         if(root == null ) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int current =1;
        int next = 0;
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            temp.add(p.val);
            current--;
            if (p.left!= null){
                queue.offer(p.left);
                next++;
            }
            if(p.right != null){
                queue.offer(p.right);
                next++;
            }
            if (current == 0){
                current = next;
                next = 0;
                // 这个地方  从 头加入 即可
                result.add(0,temp);
                temp = new ArrayList<>();
            }
        }
        return result;
    }
```

