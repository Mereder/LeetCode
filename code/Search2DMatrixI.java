/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class Search2DMatrixI {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(matrix != null && n > 0){
            int m = matrix[0].length;
            int left = 0;
            int right = m*n-1;
            while(left <= right){ // 这个地方问题 加入等号
                int mid = left + (right-left)/2; // 这个地方 用 low + 差值/2 的形式
                int row = mid / m;
                int col = mid % m;
                if(matrix[row][col] > target){
                    right = mid - 1;
                }
                else if(matrix[row][col] < target){
                    left = mid + 1;
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }
}
