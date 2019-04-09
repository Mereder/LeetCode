### 题目描述

Given a positive integer *n*, break it into the sum of **at least** two positive integers and maximize the product of those integers. Return the maximum product you can get.

**Example 1:**

```
Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
```

**Example 2:**

```
Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
```

**Note**: You may assume that *n* is not less than 2 and not larger than 58.

### 解题思路

该题就是 剪绳子问题的数字描述 版本。**从上到下思考问题，自底向上解决问题**

计算N=10

那么需要计算   1+9   2+8  3+7  4+6  5+5

为什么只需要考虑切一次呢？

因为这里的 9 8 7 6 5 都已经是经过最好切分的结果了

10 = 1+ 9 =  1+ 3+3+3    1x3x3x3 = 27   。。。

当计算出前面问题的最优解  即可

### 题解

```java
public int integerBreak(int n) {
    // not less than 2
    if(n == 2) return 1;
    if(n == 3) return 2;
    int mem[] = new int[n+1];
    // 这里从4开始 才是最优解的值，前面的存储都是为了乘法预先保存的
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
```