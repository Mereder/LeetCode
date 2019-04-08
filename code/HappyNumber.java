/*
 * Date :  2019.
 * Author : Mereder
 */
package code;
/*
* 快乐数，如果快乐则会最终返回1，不快乐 则不会出现1  始终成环！！1
* 环的话 可以想到类似链表有无环的检测。
* */

public class HappyNumber {
    public static int digitSquareSum(int n){
        int sum  = 0;
        if ( n == 1 ) return 1;
        while ( n != 0){
            int temp = n % 10;
            sum += temp*temp;
            n = n / 10;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        // int temp = digitSquareSum(n);
        int slow = n;
        int fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        }while(slow != fast);

        if (slow == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        int  test = 19;
        System.out.println(isHappy(test));
     //   System.out.println(digitSquareSum(test));
    }
}

