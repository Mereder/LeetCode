package code;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> h1 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 这个地方是值和索引同时放进去
            h1.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int error = target - nums[i];
            if (h1.containsKey(error) && h1.get(error) != i){
                return new int[] {i, h1.get(error)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int test[] = new  int[]{3,1};
        System.out.println(test[0]);
    }
}
