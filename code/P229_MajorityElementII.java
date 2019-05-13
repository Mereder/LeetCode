/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.ArrayList;
import java.util.List;

public class P229_MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (n <= 0) return result;
        int maj1=nums[0];
        int maj2=nums[1];
        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = 2; i < n ; i++) {
            if (maj1 == nums[i]){
                cnt1++;
            }
            else if (maj2 == nums[i]){
                cnt2++;
            }
            else if (cnt1 == 0){
                cnt1 = 1;
                maj1 = nums[i];
            }
            else if (cnt2 == 0){
                cnt2 = 1;
                maj2 = nums[i];
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == maj1)
                cnt1++;
            else if (nums[i] == maj2)
                cnt2++;
        }
        if (cnt1 > n / 3)
            result.add(maj1);
        if (cnt2 > n / 3)
            result.add(maj2);
        return result;
    }
}
