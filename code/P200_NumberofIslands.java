/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P200_NumberofIslands {
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


}
