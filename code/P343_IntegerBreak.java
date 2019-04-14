/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P343_IntegerBreak {
    public int integerBreak(int n) {
        // not less than 2
        if(n == 2) return 1;
        if(n == 3) return 2;
        int mem[] = new int[n+1];
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 2;
        mem[3] = 3;

        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {
                int prod = mem[j]*mem[i-j];
                if(prod > max) max = prod;
            }
            mem[i] = max;
        }

        return mem[n];
    }
}
