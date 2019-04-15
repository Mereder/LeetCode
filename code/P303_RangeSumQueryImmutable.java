/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P303_RangeSumQueryImmutable {
    class NumArray {
        public int nums[];
        public int mem[];
        public NumArray(int[] nums) {
            this.nums = nums;
            this.mem = new int[nums.length];
            mem[0] = nums[0];
            for (int i = 1; i < mem.length;i++){
                mem[i] = mem[i-1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            int result = 0;
            result = mem[j] - mem[i] + nums[i];
            return result;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
