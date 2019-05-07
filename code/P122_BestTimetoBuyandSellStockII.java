/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class P122_BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 0) return 0;
        int profit = 0;
        for(int i = 1; i < n; i++ ){
            if(prices[i] > prices[i-1])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }
}
