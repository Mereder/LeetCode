##  题目要求：

给一个2d的网格 1 代表岛屿  0 代表大海，统计岛屿的个数。注意的是，水平方向或者竖直方向相邻岛屿的话，将视为一片岛屿

网格外都是海。

测试样例：

```
Input:
11110
11010
11000
00000

Output: 1
```



## 解题思路

总体思路：逐行逐列进行探测，遇到为1的岛屿，计数同时将1置0，,然后在该点的 上下左右四个方向进行深度优先搜索。有1则置0，继续在1的四个方向进行递归。

细节点：

每次遇到一个 if( == 1) 则进行一次岛屿计数 同时将遍历过的 1 置 0 。

以i,j 为中心 进行DFS

1.需要调用DFS 进行递归搜索，边界条件（递归退出条件）是：

i j  越界（<0 或者  >n-1）  或者  grid[ i ] [ j ] 处不为1.

2.与1 连成一片的地方 一次DFS递归之后 都会被置0，然后 会回到原始的逐行逐列搜索中。



时间复杂度 O（n^3） 双层for循环 n^2 递归条件最差是 遍历一遍 ？？？ 



```java
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        // 边界条件 如果n = 0取不到列数
        if ( grid != null && n > 0){
            m = grid[0].length;
            int counts = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 没进入一次if 则 counts++，同时进入DFS进行元素置0
                    if (grid[i][j] == '1'){
                        counts++;
                        DeepFirstSearch(i,j,grid);
                    }
                }
            }

            return counts;
        }
        return 0;
    }
    public void DeepFirstSearch(int i,int j,char[][] grid){
        // 递归结束条件
        if (i < 0 || j < 0 || i > n-1 || j > m-1 || grid[i][j] != '1'){
            return;
        }
        // 中心元素置0
        grid[i][j] = 0;
        // up
        DeepFirstSearch(i-1,j,grid);
        // down
        DeepFirstSearch(i+1,j,grid);
        // left
        DeepFirstSearch(i,j-1,grid);
        // right
        DeepFirstSearch(i,j+1,grid);
    }
```

