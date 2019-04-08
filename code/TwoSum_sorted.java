package code;

public class TwoSum_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length-1;
        while(index1 < index2){
            System.out.println(index1);
            System.out.println(index2);
            if (numbers[index1]+numbers[index2] == target){
                return new int[] {index1+1,index2+1};
            }
            else if (numbers[index1]+numbers[index2] < target){
                index1++;
            }
            else {
                index2--;
            }


        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum_sorted test = new TwoSum_sorted();
        int []numbers = new int[]{2,7,11,15};
        int target = 9;
        int []result = test.twoSum(numbers,target);
        System.out.println(result);
    }
}
