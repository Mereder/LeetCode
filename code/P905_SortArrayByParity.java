/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P905_SortArrayByParity {
    // 优化解法：
    public int[] sortArrayByParity1(int[] A) {
        // i是偶数指针，j是奇数指针
        for (int i = 0, j = 0; j < A.length; j++)
            // 只要交换一次i指针才会++。
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }

    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        if (n <= 0 ) return null;

        // 冒泡排序
        for (int i = 0; i < n-1; i++) {
            boolean exch = false;
            for (int j = 0; j < n-i-1; j++) {
                if (A[j]%2==1 && A[j+1]%2==0){
                    exch = true;
                    swap(A,j,j+1);
                }
            }
            if (!exch) break;
        }
        return A;
    }

    public void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
