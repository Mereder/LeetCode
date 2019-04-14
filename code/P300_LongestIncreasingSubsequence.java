/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.Arrays;

public class P300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(nums == null || n <= 0) return  0;
        int mem[] = new int[n];
        Arrays.fill(mem,1);
        int max = mem[0];
        for (int i = 1; i< n ;i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && mem[i] < mem[j]+1) {
                    mem[i] = mem[j] + 1;
                }
                if(max < mem[i]) max = mem[i];
            }
        }
        return max;
    }
    // 通过了 问题在 binary search  应该偏向 lo
    // 当出现相等的时候
    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        if(nums == null || n <= 0)
            return  0;
        if (n == 1) return 1;
        int mem[] = new int[n+1];
        Arrays.fill(mem,0);
        int len = 0;
        mem[len] = nums[0];
        for (int i = 1; i< n ;i++) {
            if(nums[i] > mem[len]){
                len++;
                mem[len] = nums[i];
            }
            else if(nums[i] > mem[len]) continue;
            else {
                int replece = BinarSearch(mem,0,len,nums[i]);
                mem[replece] = nums[i];
            }
        }
        return len;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
    private int BinarSearch(int[] input,int lo,int hi,int key) {

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(input[mid] <= key){
                lo = mid + 1;
            }
            else  {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        P300_LongestIncreasingSubsequence test = new P300_LongestIncreasingSubsequence();
        int nums[] = {4,10,4,3,8,9};
        test.lengthOfLIS2(nums);
    }


}
