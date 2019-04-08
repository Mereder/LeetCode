package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {

        return 1;
    }
    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input == null || k == 0) return result;
        // k = input.length - k;
        int low = 0;
        int high = input.length - 1;
        while(low < high){
            int index = partition(input,low,high);
            if(index ==  k) break;
            else if(index < k){
                low = index+1;
            }
            else{
                high = index-1;
            }
        }
        for(int i = 0; i < k ; i++){
            result.add(input[i]);
        }
        return result;
    }
    public static int partition(int [] input,int low,int high){

        return 0;
    }
    public static void swap(int[] input,int a,int b){
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    public static void main(String[] args) {
        int test[] = {3,2,3,1,2,4,5,5,6};
        int test1[] = {3,2,1,5,6,4};
        ArrayList<Integer> resu = new ArrayList<>();
        resu = GetLeastNumbers_Solution(test,4);
        System.out.println(resu);
         //System.out.println(partition(test1,0,7));
    }
}
