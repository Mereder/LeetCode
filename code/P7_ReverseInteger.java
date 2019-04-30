package code;

public class P7_ReverseInteger {
    public int reverse(int x ){
        long ans = 0;
        while(x != 0){
            ans = ans*10 + x%10;
            x = x/10;
        }
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE){
            ans = 0;
        }
        return (int )ans;
    }

    public static void main(String[] args) {
        int test = Integer.MAX_VALUE+1;
        P7_ReverseInteger reverseInteger = new P7_ReverseInteger();
        int result = reverseInteger.reverse(test);
        System.out.println(result);
    }
}
