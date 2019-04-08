/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class QuickSort {
    public static void Quicksort(int[] arr,int low,int high){
        if(low >= high) return;
        int k = partation(arr,low,high);
        Quicksort(arr,low,k-1);
        Quicksort(arr,k+1,high);
    }

    public static int partation(int arr[],int low,int high){
        int temp = arr[low];
        while(low < high){
            while ( temp <= arr[high] && low < high){
                high--;
            }


        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
