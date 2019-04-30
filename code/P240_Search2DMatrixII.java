/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P240_Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(matrix != null && n > 0){
            int m = matrix[0].length;
            int i = 0;
            int j = m - 1;
            while(i < n && j >=0){
                if(matrix[i][j] < target){
                    i++;
                }
                else if(matrix[i][j] > target){
                    j--;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
}
