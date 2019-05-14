题目链接: [ 283. Move Zeroes](<https://leetcode.com/problems/move-zeroes/>)

相似题目[27. Remove Element](<https://leetcode.com/problems/remove-element/>)

### 题目描述

Given an array `nums`, write a function to move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

简而言之，0都挪到数组后边，其他数字保持顺序不变。

**Example:**

```
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
```

**Note**:

1. You must do this **in-place** without making a copy of the array.
2. Minimize the total number of operations

### 解题思路

我的解法：

冒泡思想，把0都冒泡到最后，基于交换。非常好实现，复杂度O（n^2）

巧妙的解法：

只需要关注非0的数字即可，即把非0的数都前移（覆盖），最后剩下的位置都补成0即可。

需要一个变量来标记非0数字的下标。

### 题解

1、冒泡思想

```java
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n <= 0) return;
        boolean change = false;
        for(int i = 0;i<n;i++){
            
            for(int j = 0;j<n-i-1;j++){
                if(nums[j] == 0 && nums[j+1]!=0){
                    change = true;
                    exchange(nums,j,j+1);
                }    
            }
            if(!change) break;
        }
    }
    public void exchange(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
```

2、覆盖

```java
public void moveZeroes(int[] nums) {
    int n = nums.length;
    if(n <= 0) return;
    
    int pos = 0;
    for(int i = 0;i<n;i++){
        if(nums[i] != 0){
            nums[pos++] = nums[i];
        }
    }
    while(pos < n){
        nums[pos++] = 0;
    }
}
```