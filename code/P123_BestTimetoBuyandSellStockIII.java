/*
 * Date :  2019.
 * Author : Mereder
 */

package code;
//
//T[i][2][0] = max(T[i-1][2][0], T[i-1][2][1] + prices[i])`
//`T[i][2][1] = max(T[i-1][2][1], T[i-1][1][0] - prices[i])`
//`T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1] + prices[i])`
//`T[i][1][1] = max(T[i-1][1][1], -prices[i])`(参考前面 为啥这个等式这么写)

public class P123_BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 0 ) return 0;
        int T_i20 = 0;
        int T_i21 = Integer.MIN_VALUE;
        int T_i10 = 0;
        int T_i11 = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++){
            T_i20 = Math.max(T_i20,T_i21+prices[i]);
            T_i21 = Math.max(T_i21,T_i10-prices[i]);
            T_i10 = Math.max(T_i10,T_i11+prices[i]);
            T_i11 = Math.max(T_i11,-prices[i]);
        }
        return T_i20;
    }
}
