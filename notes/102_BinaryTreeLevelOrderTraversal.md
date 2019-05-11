### 题目描述

Given a binary tree, return the *level order* traversal of its nodes' values. (ie, from left to right, level by level).

For example:

简而言之：按层次遍历二叉树，但不是一次性输出。且按层输出。

Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

return its level order traversal as:

```
[
  [3],
  [9,20],
  [15,7]
]
```

### 题解

[剑指offer——按层次遍历二叉树](https://www.jianshu.com/p/50ed487ebbc0)

```java
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int current = 1;
        int next = 0;
        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            temp.add(p.val);
            current--;
            if(p.left != null){
                queue.offer(p.left);
                next++;
            }
            if(p.right != null){
                queue.offer(p.right);
                next++;
            }
            if(current == 0){
                result.add(temp);
                temp = new ArrayList<>();
                current = next;
                next = 0;
            }
        }
        return result;
    }
```

