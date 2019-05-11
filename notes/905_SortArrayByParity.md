### 题目描述

Given an array `A` of non-negative integers, return an array consisting of all the even elements of `A`, followed by all the odd elements of `A`.

You may return any answer array that satisfies this condition.

简而言之：数组奇数在后，偶数在前，奇数或偶数内不考虑顺序。

**Example 1:**

```
Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
```

**Note:**

1. `1 <= A.length <= 5000`
2. `0 <= A[i] <= 5000`

### 解题思路

1. 我的冒泡：更改条件，冒泡的条件不再是大小，而是两个值前一个为奇数，后一个为偶数就交换。
   对于冒泡多说一句：冒泡的外层表示已经排序元素个数，内层表示一次遍历，内层循环的上界是`总个数-排序个数-1`。可通过有无交换来优化。
2. 优化解法：一轮遍历，奇偶指针。（有点类似 一轮快排，中间的分界条件就是奇偶性）

### 题解

我的解法：

```java
    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        if (n <= 0 ) return null;
        
        // 冒泡排序
        for (int i = 0; i < n-1; i++) {
            boolean exch = false;
            for (int j = 0; j < n-i-1; j++) {
                if (A[j]%2==1 && A[j+1]%2==0){
                    exch = true;
                    swap(A,j,j+1);
                }
            }
            if (!exch) break;
        }
        return A;
    }

    public void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
```

优化解法：（代码少 一轮遍历）

```java
public int[] sortArrayByParity(int[] A) {
    // i是偶数指针，j是奇数指针
    for (int i = 0, j = 0; j < A.length; j++)
        // 只要交换一次i指针才会++。
        if (A[j] % 2 == 0) {
            int tmp = A[i];
            A[i++] = A[j];
            A[j] = tmp;;
        }
    return A;
}
```