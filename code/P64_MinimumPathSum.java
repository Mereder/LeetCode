/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        assert grid == null:"error";
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
                    if (i - 1 < 0) up = 0;
                    else up = minResult[i - 1][j];
                    if (j - 1 < 0) left = 0;
                    else left = minResult[i][j - 1];
                    minResult[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        return minResult[m-1][n-1];
    }
}
