### 题目描述

Say you have an array for which the *i*th element is the price of a given stock on day *i*.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

简而言之，只有一次买卖机会，并且不可以再买之前就卖。时间顺序上 先买再卖

**Example 1:**

```
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
```

**Example 2:**

```
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

### 解题思路

只允许一次买卖，并且买在卖之前。

只有当我们买的时候是较小的，并且之后卖出时有较大利润。

min_value 来记录数组中的最小值，也就是买入的时候

max_diff 表示最大利润。

只需要一次遍历：如果当前值比min_value还要小，那么之后卖出时候，当前值获得利润肯定比Min_value获得的要大，所以更新min_value为当前值。同时max_diff记录最大差值，如果当前值减去min_value收获的利润比max_diff要大，那么更新max_diff。

也就是说，在计算i卖出时可以获得的最大利润，只需要记住i-1个数中的最小值。

### 题解

```java
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
```
