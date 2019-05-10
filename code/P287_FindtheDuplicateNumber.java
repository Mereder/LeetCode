/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P287_FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if (n <= 0 ) return 0;
        int slow = nums[nums[0]];
        int fast = nums[nums[nums[0]]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = nums[0];

        while (fast == slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
