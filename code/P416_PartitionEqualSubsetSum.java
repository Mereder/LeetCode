/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.Arrays;

public class P416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }
        return dp[sum];
    }
    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        if (n <= 0) return false;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum %2 == 1){
            return false;
        }
        int target = sum >> 1;
        int [][]dp = new  int[n+1][target+1];
        //
        int y = target;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <=  target; j++) {
                int left = dp[i-1][j];
                int right;
                if (j-nums[i-1] < 0){
                    right = Integer.MIN_VALUE;
                }
                else {
                    right = dp[i-1][j-nums[i-1]]+nums[i-1];
                }
                dp[i][j] = Math.max(left,right);
            }
        }
        if (dp[n][target] == target)
            return true;
        return false;
    }

}
