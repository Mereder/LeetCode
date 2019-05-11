### 问题描述

Say you have an array for which the *i*th element is the price of a given stock on day *i*.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

**Note:** You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

**Example 1:**

```
Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
```

**Example 2:**

```
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
```

**Example 3:**

```
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

### 解题思路

我们想要找到最大的利润，不限制交易次数。

只要股票的价格是上升的，那么我们就能赚取利润，下降的时候。我们不做买卖。

说白了，我们就是找到整个数组的单调递增区间，计算整个区间的增加值即可

举例： 1 2 3 4 5   是一个单调递增的区间，最大利润为 5-1。

举例： 1,2，5,3,4 最大利润是 （5-1 +  4-3）为5。其中125是一个递增序列，34是一个递增序列

举例：7,6,5,1,4,3,2  最大利润为  4-1 =3  其他阶段都是递减 只要 14是递增。

条件就是  prices[i-1] < prices[i]  :利润+= prices[i]-prices[i-1]

其实以1,2,3,4,5为例，首先是 利润 += 2-1 然后发现3比2还大，然后就 利润+= 3-2 然后发现4比3还大 再 利润+=4-3.... 这个过程  2-1+3-2+4-3 + 5-4 = 5-1 = 4

### 题解

```java
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
```

