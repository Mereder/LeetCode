### 题目描述

Given two sorted integer arrays *nums1* and *nums2*, merge *nums2* into *nums1* as one sorted array.

**Note:**

- The number of elements initialized in *nums1* and *nums2* are *m* and *n*respectively.
- You may assume that *nums1* has enough space (size that is greater or equal to *m* + *n*) to hold additional elements from *nums2*.

**Example:**

```java
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```

### 解题思路

从后向前遍历，大的在后边，能确认下来。

比较两个数组最后的元素，较大的放到数组1的末尾，同时，较大数组的下标--。

### 题解

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    // 从后向前的写法
    int i = m-1;
    int j = n-1;
    int tail = m+n-1;
    while(i >= 0 && j >= 0 ){
        if(nums1[i] > nums2[j]){
            nums1[tail] = nums1[i];
            tail--;
            i--;
        }
        else{
            nums1[tail--] = nums2[j--];
        }
    }
    while(j >= 0){
        nums1[tail--] = nums2[j--];
        
    }
}
```