### 题目描述

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

**Example 1:**

```
Input: 121
Output: true
```

**Example 2:**

```
Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
```

**Example 3:**

```
Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
```

### 解题思路

Coud you solve it without converting the integer to a string?

不转换成字符串的话，考虑的就是% 取数字，一边取数，一边生成数。

121%10 -> 1     12%10->2      1%10->1     再根据依次取出来的数生成  121

只有生成的数和原数相等 才是 回文

1234   生成之后 是  4321  不相等。

PS: 负数是 false  0  是 true;

### 题解

```java
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x == 0) return true;
        int rever = reverse(x);
        if(rever == x) return true;
        return false;
    }
    
    public int reverse(int x){
        int result = 0;
        while(x!= 0){
            int a =  x%10;
            result = result*10+a;
            x = x/10;
        }
        return result;
    }
}
```

 