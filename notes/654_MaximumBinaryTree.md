题目链接: [654. Maximum Binary Tree](<https://leetcode.com/problems/maximum-binary-tree/>)

### 题目描述

Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

1. The root is the maximum number in the array.
2. The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
3. The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.

Construct the maximum tree by the given array and output the root node of this tree.

**简而言之：根结点是数组中最大的，左子树的结点是数组中max左侧数组最大的值，右子树是max右侧。**

**Example 1:**

```
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
```

**Note:**

1. The size of the given array will be in the range [1,1000].

### 解题思路

根据描述，很明显的告诉我们要用递归去解决，对于一个数组，建立一个以最大值为根的二叉树。左子树就是数组左侧，右子树就是数组右侧。

问题就分为了两部分：

1. 找当前数组的最大
2. 根据最大进行划分，左数组和右数组
3. 递归构建左右子树

找当前数组最大的时候，我想了下TOP-K问题，但是数组元素是不可以交换顺序的，会影响后面构建。所以老老实实的遍历找最大O（n）

### 题解

```java
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        //   1.找最大
        int n = nums.length;
        if (n <= 0) return null;
        return helper(nums,n,0,n-1);
    }

    public TreeNode helper(int[] nums,int n,int lo,int hi){
         if (lo > hi) return null;
         if (lo == hi) return new TreeNode(nums[lo]);
         //  找最大， 找到后
        int max = Integer.MIN_VALUE;
        int index = 0;
        // 这个地方注意，第一遍写的时候 i=0 ;i<n然后就去无限递归了。。。memory limited error
        for (int i = lo; i <= hi; i++) {
            if (max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        //  [3,2,1,6,0,5]
        TreeNode root=  new TreeNode(max);
        // 划分左侧数组
        root.left = helper(nums,index,lo,index-1);
        // 划分右侧数组
        root.right = helper(nums,n-index-1,index+1,hi);
        return root;
    }
```



