/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P674_LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if(n <=0 || nums == null) return 0;
        int mem[] = new int[n];
        Arrays.fill(mem,1);
        for(int i = 0;i < n;i++){
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    mem[i] = mem[j]+1;
                }
            }
        }
        return mem[n-1];
    }
    public int findLCS(String A, int n, String B, int m) {
        if(n <=0 || m<=0) return 0;
        int mem[][] = new int[n+1][m+1];

        for(int i = 1;i <= n;i++){
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i-1) ==  B.charAt(j-1)){
                    mem[i][j] = mem[i][j]+1;
                }
                else mem[i][j] = Math.max(mem[i-1][j],mem[i][j-1]);
            }
        }
        return mem[n][m];
    }
}
