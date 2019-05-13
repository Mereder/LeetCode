/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P169_MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n <= 0) return 0;

        int maj = nums[0];
        int cnt = 1;
        for(int i = 1; i< n;i++){
            if(nums[i] == maj) cnt++;
            else cnt--;
            if(cnt < 0){
                cnt = 0;
                maj = nums[i];
            }
        }
        return maj;
    }
}
