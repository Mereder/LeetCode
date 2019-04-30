/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P695_maxAreaOfIsland {
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
        if (i<n && i >= 0 && j<m && j >=0){
            if (grid[i][j] == 1){
                grid[i][j] = 0;
                return DFS(grid,i-1,j) + DFS(grid,i+1,j) + DFS(grid,i,j-1) + DFS(grid,i,j+1) + 1;
            }
            else if (grid[i][j] == 0)
                return 0;
        }
        return  0;
    }

    public static void main(String[] args) {
        P695_maxAreaOfIsland test = new P695_maxAreaOfIsland();
        int grid[][] =
        {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        System.out.println(test.maxAreaOfIsland(grid));
    }
}
