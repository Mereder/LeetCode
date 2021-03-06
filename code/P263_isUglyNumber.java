/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P263_isUglyNumber {
    public boolean isUgly(int num) {
        if(num == 0){
            return false;
        }
        while(num % 2 == 0){
            num = num / 2;
        }
        while(num % 3 == 0){
            num = num / 3;
        }
        while(num % 5 == 0){
            num = num / 5;
        }
        if (num == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        int test = 10;
        P263_isUglyNumber aaa = new P263_isUglyNumber();
        System.out.print(aaa.isUgly(test));
    }
}
