/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P832_FlippinganImage {
    public int[][] flipAndInvertImage(int[][] A) {
         // 1 <= A.length = A[0].length <= 20 不用判断输入问题
        int n = A.length;
        // flip
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= (n-1)/2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][n-1-j];
                A[i][n-1-j] = temp;
            }
        }
        // invert
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) A[i][j] = 1;
                else A[i][j] = 0;
            }
        }
        return A;
    }
}
