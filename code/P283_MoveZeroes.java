/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P283_MoveZeroes {


    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n <= 0) return;

        int pos = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] != 0){
                nums[pos++] = nums[i];
            }
        }
        while(pos < n){
            nums[pos++] = 0;
        }
    }
    public void moveZeroes1(int[] nums) {
        int n = nums.length;
        if(n <= 0) return;
        boolean change = false;
        for(int i = 0;i<n;i++){

            for(int j = 0;j<n-i-1;j++){
                if(nums[j] == 0 && nums[j+1]!=0){
                    change = true;
                    exchange(nums,j,j+1);
                }
            }
            if(!change) break;
        }
    }
    public void exchange(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
