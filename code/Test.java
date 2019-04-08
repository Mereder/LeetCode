/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class Test {
    public static void main(String[] args) {
        int a = 5;
        fun(a);
        System.out.println(a);// 输出结果为5
    }
    private static void fun(int a) {
        a += 1;
    }
}
