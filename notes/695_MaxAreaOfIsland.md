### 题目描述

Given a non-empty 2D array `grid` of 0's and 1's, an **island** is a group of `1`'s (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

简而言之，就是数矩阵里面  最大相连1的个数（相连条件仅限 上下左右四个方向）

**Example 1:**

```
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
```

Given the above grid, return 

```
6
```

. Note the answer is not 11, because the island must be connected 4-directionally.

### 解题思路

跟 200题 统计岛屿数量类似，就是在计数岛屿的基础上  每次都统计下 岛屿的“面积”

总体思路还是DFS 为主，

当确认 (i,j)是1的时候，则开始对(i,j)以及周边进行DFS，  关键代码

```java
            // 在递归里面  当找到 1的时候 进行的操作  上+下+左+右+1
			if (grid[i][j] == 1){
                grid[i][j] = 0;
                return DFS(grid,i-1,j) + DFS(grid,i+1,j) + DFS(grid,i,j-1) + DFS(grid,i,j+1) + 1;
            }
```

### 题解

```java
    public int n;
    public int m;
    public  int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        if ( n <= 0 ) return 0;
        m = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1){
                    // 每次返回一个面积 与最大面积比较
                    int Area = DFS(grid,i,j);
                    if (Area > maxArea) {
                        maxArea = Area;
                    }
                }
            }
        }
        return maxArea;
    }
    public int DFS(int[][] grid,int i,int j){
        // 搜索点到边界外  也是递归结束标志
        if (i<n && i >= 0 && j<m && j >=0){
            if (grid[i][j] == 1){
                // 置 0 表示已经遍历过
                grid[i][j] = 0;
                // 上+下+左+右+1
                return DFS(grid,i-1,j) + DFS(grid,i+1,j) + DFS(grid,i,j-1) + DFS(grid,i,j+1) + 1;
            }
            else if (grid[i][j] == 0)
                return 0;
        }
        return  0;
    }
```

