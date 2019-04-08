/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class ClimbingStairs {
    // 递归解法  无优化
    public int climbStairs1(int n) {
        if(n == 0 || n==1 || n == 2) return n;
        return climbStairs1(n-1) + climbStairs1(n-2);
    }
    // 自顶向下  递归求解 优化过程  过程变量存储。
    public int climbStairs2(int n) {
        if(n == 0 || n==1 || n == 2) return n;
        int []mem = new int[n];
        for (int i = 0; i < n; i++) {
            mem[i] = -1;
        }
        mem[0] = 1;
        mem[1] = 2;
        // n的话 越界了
        return dp(n-1,mem);
    }
    public int dp(int n,int []mem){
        if (mem[n] == -1){
            mem[n] = dp(n-1,mem) + dp(n-2,mem);
        }
        return mem[n];
    }

    // 自底向上  迭代求解
    public int climbStairs3(int n) {
        if(n == 0 || n==1 || n == 2) return n;
        int []mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for (int i = 2; i < n; i++) {
            mem[i] = mem[i-2] + mem[i-1];
        }
        return mem[n-1];
    }
    // 自底向上， 迭代求解  优化空间复杂度
    public int climbStairs4(int n) {
        if(n == 0 || n==1 || n == 2) return n;
        int a = 1;
        int b = 2;
        for (int i = 2; i < n; i++) {
            int temp = a+b;
            a = b;
            b = temp;
        }
        return b;
    }


    public static void main(String[] args) {
        ClimbingStairs test = new ClimbingStairs();
        System.out.println(test.climbStairs4(4));
    }
}
