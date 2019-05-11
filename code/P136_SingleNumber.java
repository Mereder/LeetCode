/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P136_SingleNumber {
    public int singleNumber(int[] nums){
        int n = nums.length;
        if(n <=0 ) return 0;
        int sum = 0;
        //  逐个异或。总体上看其实相同的两个异或就消掉了只会留下唯一的数
        // A XOR A = 0     0 XOR A = A
        for (int i = 0; i < n; i++) {
            sum ^= nums[i];
        }
        return sum;
    }
}
