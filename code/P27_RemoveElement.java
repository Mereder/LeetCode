/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(n <= 0) return 0;

        int len = 0;
        for(int num:nums){
            if(num != val){
                nums[len++] = num;
            }
        }
        return len;
    }
}
