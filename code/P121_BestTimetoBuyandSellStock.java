/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import sun.font.FontRunIterator;

public class P121_BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 0 ) return 0;
        int min_value = Integer.MAX_VALUE;
        int max_diff = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            if(prices[i] < min_value){
                min_value = prices[i];
            }
            if(prices[i] - min_value > max_diff){
                max_diff = prices[i]-min_value;
            }
        }
        return max_diff;
    }
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        if (n<=0) return 0;
        int [][] T = new int[n+1][2];
        T[0][0] = 0;
        T[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            T[i][0] = Math.max(T[i-1][0],T[i-1][1]+prices[i-1]);
            T[i][1] = Math.max(T[i-1][1],-prices[i-1]);
        }
        return T[n][0];
    }

    public static void main(String[] args) {
        P121_BestTimetoBuyandSellStock test = new P121_BestTimetoBuyandSellStock();
        int []prices = {7,1,5,3,6,4};
        System.out.println(test.maxProfit(prices));
        System.out.println(test.maxProfit1(prices));
    }
}
