/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P704_BinarySearch {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] > target){
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
