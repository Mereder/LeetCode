/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P307_RangeSumQueryMutable {
    class NumArray {
        public int[] nums;
        private int []mems;
        public NumArray(int[] nums) {
            if (nums == null || nums.length <=0)return;
            this.nums = nums;
            this.mems = new int[nums.length];
            this.mems[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                this.mems[i] = this.mems[i-1] + nums[i];
            }
        }

        public void update(int i, int val) {
            this.nums[i] = val;
            this.mems[0] = nums[0];
            for (int j = 1; j < nums.length; j++) {
                this.mems[j] = this.mems[j-1] + nums[j];
            }

        }

        public int sumRange(int i, int j) {
            return this.mems[j] - mems[i] + nums[i];
        }
    }
}
