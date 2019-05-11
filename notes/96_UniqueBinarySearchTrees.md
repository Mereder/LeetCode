题目链接：[96. Unique Binary Search Trees](<https://leetcode.com/problems/unique-binary-search-trees/>)

### 题目描述

Given *n*, how many structurally unique **BST's** (binary search trees) that store values 1 ... *n*?

**Example:**

```
Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

### 解题分析

（自己没想到，看的discuss，大神的解法，配上自己的理解，溜~）

这个题跟有一个DP的问题非常像，我先不说，大家可以猜一下。

首先如何划分树？先找到一个根节点，然后分成左右两堆，再将左右两堆依次建树。这也就是划分了子问题。那么我们需要用参数的形式来表示：dp[n]表示，有n个数的时候，可以构造的BST数目。

假设我们在k这个地方进行划分（也就是以k为根节点），那么左侧就是`1~(k-1)`，右侧也就是`k+1~N`，然后左右再去构造子树。所以现阶段我们得到了递推方程:$dp[n] = \sum_{k=1}^{n}{dp[k-1]*dp[n-k]}$

这个式子我们以n=4为例将其展开就是:
$$
dp[4] = dp[0]*dp[3]+dp[1]*dp[2]+dp[2]*dp[1]+dp[3]*dp[0]
$$
这个式子到底什么意思呢，就是说当有四个数字可以让我们拿来当根结点的时候，我们依次让1,2,3,4当根节点。

由于BST的顺序性，**左<根<右**。那么让1当根节点，1的左为空即dp[0]，1的右侧为{2,3,4}又是三个节点，所以为dp[3]。那么这样的组合也就是dp[0]*dp[3]。同理可以解释剩下的三项因式的含义。

而我们要求的是dp[n]，而求dp[n]之前需要知道 dp[0]~dp[n-1]。

从下至上求解问题：初始化dp[0]=dp[1]=1。(树为null也算一个树。)



**这个问题跟剪绳子，跟IntegerBreak，都是相同的思路。感兴趣的可以看:[IntegerBreak](<https://www.jianshu.com/p/ddab7b3f1f49>)**

### 题解

```java
        public int numTrees(int n) {
            if (n <= 0) return 0;
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[i-j]*dp[j-1];
                }
            }
            return dp[n];
        }
```

