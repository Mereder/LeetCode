### 题目描述

Given an array of integers `A` sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 简而言之：将一个非递减序列，按照元素乘方的大小排序。返回乘方的非递减序列

**Example 1:**

```
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
```

**Example 2:**

```
Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
```

**Note:**

1. `1 <= A.length <= 10000`
2. `-10000 <= A[i] <= 10000`
3. `A` is sorted in non-decreasing order.

### 解题思路

二次函数，中间低，两端高，从两端开始进行比较。绝对值大的那个也是全局最大的。其乘方放在返回数组的最后一位，依次类推。

### 题解

```java
    public int[] sortedSquares(int[] A) {
       
        int n = A.length;
        // 比较两端的绝对值 i 左  j右
        int i=0,j=n-1;
        int[] res = new int[n];
        for (int k = n-1; k>=0; k--) {
            // 最大的放在后边
            if (Math.abs(A[i]) > Math.abs(A[j])){
                res[k] = A[i]*A[i];
                i++;
            }
            else {
                res[k] = A[j]*A[j];
                j--;
            }
        }
        return res;
    }
```

