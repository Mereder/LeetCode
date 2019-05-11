### 题目描述

Given an unsorted array of integers, find the length of longest increasing subsequence.

**Example:**

```
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
```

**Note:**

- There may be more than one LIS combination, it is only necessary for you to return the length.
- Your algorithm should run in O(*n2*) complexity.

**Follow up:** Could you improve it to O(*n* log *n*) time complexity?







### 解题思路

O（N^2） 思路



O（NlogN）思路：

假设要寻找最长上升子序列的序列是a[n]，然后寻找到的递增子序列放入到数组b中。

（1）将数组a的第一个元素放入数组中，然后遍历数组a，让每个元素都和已经放入到b数组中**最后一个元素**进行比较；

（2）如果比b数组中最后一个元素大，则将数组长度+1，并把该元素插入到b数组的最后一个元素后；

（3）如果比b数组中最后一个元素小，就要运用二分法进行查找，查找出第一个比该元素大（或等于）的最小的元素，然后将其替换。

（4,10,4,3,8,9） 这个例子。





### 题解





