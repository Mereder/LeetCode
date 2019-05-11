题目链接:[637. Average of Levels in Binary Tree](<https://leetcode.com/problems/average-of-levels-in-binary-tree/>)

### 题目描述

Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

**Example 1:**

```
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
```

**Note:**

1. The range of node's value is in the range of 32-bit signed integer.

**提示很重要，但是最好不靠提示也能想到越界问题。**

### 解题注意

总体思路还是 二叉树的层次遍历。

sum可能会出现越界，所以需要 long型的sum

 比如同一层出现两个及以上  **[2147483647,2147483647,2147483647]**，相加后直接就爆掉了int了。

### 题解

```java
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int current = 1;
        int next = 0;
        // 防止越界
        long sum = 0;
        int num = current;
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            sum += p.val;
            current--;
            if(p.left!= null){
                queue.offer(p.left);
                next++;
            }
            if(p.right!=null){
                queue.offer(p.right);
                next++;
            }
            // 重点关注的地方
            if(current == 0){
                double temp = sum / (num*1.0);
                result.add(temp);
                num = next;
                current = next;
                next = 0;
                sum = 0;
            }
        }
        return result;
    }
```

