/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P977_SquaresofaSortedArray {
    public int[] sortedSquares(int[] A) {
        // 比较两端的绝对值
        int n = A.length;
        int i=0,j=n-1;
        int[] res = new int[n];
        for (int k = n-1; k>=0; k--) {
            // 最大的放在后边
            if (Math.abs(A[i]) > Math.abs(A[j])){
                res[k] = A[i]*A[i];
                i++;
            }
            else {
                res[k] = A[j]*A[j];
                j--;
            }
        }
        return res;
    }
}
