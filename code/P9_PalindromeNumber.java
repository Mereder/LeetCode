/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P9_PalindromeNumber {
    public static  boolean isPalindrome(int x) {
        if(x <= 0) return true;
        int rever = reverse(x);
        if(rever == x) return true;
        return false;
    }

    public static int reverse(int x){
        int result = 0;
        while(x!= 0){
            int a =  x%10;
            result = result*10+a;
            x = x/10;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 121;
        int b = 1234;
        System.out.println(isPalindrome(a));
        System.out.println(isPalindrome(b));
    }
}
