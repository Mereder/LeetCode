### 题目描述

Given a binary tree containing digits from `0-9` only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path `1->2->3` which represents the number `123`.

Find the total sum of all root-to-leaf numbers.

**Note:** A leaf is a node with no children.

简而言之：求所有根到叶子的路径 所代表的值  的和。

**Example:**

```
Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
```

**Example 2:**

```
Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
```

### 解题思路

以路径 4->9->5 为例。

计算过程是：到4结点，则 sum = sum\*10+4 = 4;到9结点，则sum=sum\*10+9 = 49;到5结点sum=sum*10+5=495。

在第二层如果去到1结点，同样有 sum=49*10+1=491。所以根节点的左侧为：495+491

同理可得根节点右侧为：4*10+0 = 40.

总的值为 495+491+40 = 1026

这个递归写代码简单，文字描述真费劲。。。

### 题解

```java
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        return helper(root,sum);
    }
    public int helper(TreeNode root,int sum){
        if(root == null) return 0;
        // 递归 条件 出口
        if(root.left == null && root.right == null)
            return sum*10+root.val;
        // 递归。
        return helper(root.left,sum*10+root.val)
            + helper(root.right,sum*10+root.val);
    }
}
```

