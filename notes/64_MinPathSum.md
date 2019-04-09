### 题目描述

Given a *m* x *n* grid filled with non-negative numbers, find a path from top left to bottom right which *minimizes* the sum of all numbers along its path.

**Note:** You can only move either down or right at any point in time.

**Example:**

```
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
```

### 解题思路

动态规划：

动态转移方程：$S[i][j] = min(S[i - 1][j], S[i][j - 1]) + grid[i][j]​$

有了转移方程 就很好写了。

### 题解


```java
public int minPathSum(int[][] grid) {
    if(grid == null) return 0;
    int m = grid.length; // rows
    if (m <= 0) return 0;
    int n = grid[0].length;
    int[][] minResult = new int[m][n];
    minResult[0][0] = grid[0][0];
    int up = 0,left = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0) continue;
            else {
                // 按照转移方程写 S[i][j] = min(S[i - 1][j], S[i][j - 1]) + grid[i][j]
                // 处理下边界条件
                if (i - 1 < 0) up = Integer.MAX_VALUE;
                else up = minResult[i - 1][j];
                if (j - 1 < 0) left = Integer.MAX_VALUE;
                else left = minResult[i][j - 1];
                minResult[i][j] = grid[i][j] + Math.min(up, left);
            }
        }
    }
    return minResult[m-1][n-1];
}
```

优化方案：

使用了 M*N的额外矩阵，实际上不需要这么大的空间。每次仅跟  上 左 两个方向有关

