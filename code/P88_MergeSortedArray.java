/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后向前的写法
        int i = m-1;
        int j = n-1;
        int tail = m+n-1;
        while(i >= 0 && j >= 0 ){
            if(nums1[i] > nums2[j]){
                nums1[tail] = nums1[i];
                tail--;
                i--;
            }
            else{
                nums1[tail--] = nums2[j--];
            }
        }
        while(j >= 0){
            nums1[tail--] = nums2[j--];
        }
    }
}
