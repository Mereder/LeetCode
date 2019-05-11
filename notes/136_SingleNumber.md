题目链接：[136. Single Number](<https://leetcode.com/problems/single-number/>)

### 题目描述

Given a **non-empty** array of integers, every element appears *twice* except for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

简而言之：不使用额外空间，且在O(N)时间复杂度下找到整个重复的数字。

**Example 1:**

```
Input: [2,2,1]
Output: 1
```

**Example 2:**

```
Input: [4,1,2,1,2]
Output: 4
```

### 解题思路

异或！！！

基于异或两个最基本的性质：$ aXORa = 0 \ \ \ aXOR0 = a$

就是数字和他本身异或就是0，数字和0异或还是数字本身。

整个数组除了一个数只出现一次，其他都出现了2次。那么整个数组进行异或之后，根据上边的性质，只会保留下出现一次的数字。

### 题解

```java
    public int singleNumber(int[] nums){
        int n = nums.length;
        if(n <=0 ) return 0;
        int sum = 0
        //  逐个异或。总体上看其实相同的两个异或就消掉了只会留下唯一的数
        // A XOR A = 0     0 XOR A = A
        for (int i = 0; i < n; i++) {
            sum ^= nums[i];
        }
        return sum;
    }
```

