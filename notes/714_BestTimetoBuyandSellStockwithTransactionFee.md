### 题目描述

Your are given an array of integers `prices`, for which the `i`-th element is the price of a given stock on day `i`; and a non-negative integer `fee` representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

prices是一个序列的股票价格。可以进行多次买卖交易，每一次交易都需要支付费用。一次不可以同时买大于1个的股票。（买之前必须卖掉）

**Example 1:**

```
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1Selling at prices[3] = 8Buying at prices[4] = 4Selling at prices[5] = 9The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
```

**Note:**

`0 < prices.length <= 50000`.

`0 < prices[i] < 50000`.

```
0 <= fee < 50000
```

### 解题思路

（没思路....）

看了大神的解题方案，找了一种自己最容易理解的。

第i天有两种状态，买当天的股票或者卖当天的股票。（还有第三种 不买也不卖）

买用buy[days] 来记录，卖得话用sell[days] 来记录

**状态转移方程**

在第i天，我们可以买股票，那么第i天的buy状态就是`sell[i - 1] - prices[i]`，如果什么都不做，状态就是`buy[i-1]`
$buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);$
第i天，我们可以卖出股票，那么卖出状态就是`buy[i - 1] + prices[i]`，如果什么都不做，那么卖出的状态就是`sell[i-1]`
$sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);$

最终的目标是股票卖出且利润最大，返回`sell[days-1]`

**初始化**