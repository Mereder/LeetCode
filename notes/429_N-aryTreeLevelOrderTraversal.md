### 题目描述

Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a `3-ary` tree:

 

![img](https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png)

 

We should return its level order traversal:

```
[
     [1],
     [3,2,4],
     [5,6]
]
```

**Note:**

1. The depth of the tree is at most `1000`.
2. The total number of nodes is at most `5000`.

### 题解

这个还不是完全的层次遍历，以为输出的时候实际上是按层输出的，层与层之间属于不同的List。

这个时候需要两个变量一个保存当前层结点个数，一个保存下一层。（参考[按层次打印二叉树](https://www.jianshu.com/p/50ed487ebbc0) )

```java

```

