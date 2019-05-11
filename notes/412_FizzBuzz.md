题目链接：[412. Fizz Buzz](<https://leetcode.com/problems/fizz-buzz/>)

### 题目描述

Write a program that outputs the string representation of numbers from 1 to *n*.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

简而言之：能同时被3和5整除输出 "FizzBuzz",能被3整除输出“Fizz”，能被5整除输出“Buzz”,其他都输出数即可。

**Example:**

```
n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
```

### 题解

题目简单，注意两点：

1. 判断的优先级：先判断能同时被3和5整除。再判断其他。
2. 整型转字符串：（java：Integer.toString(10)）

```java
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        if(n <= 0) return result;
        for( int i = 1; i <= n ; i++){
           
            if(i%3 ==0 && i%5 == 0)
                result.add("FizzBuzz");
            else if(i%3 == 0)
                result.add("Fizz");
            else if(i%5 == 0)
                result.add("Buzz");
            else
                result.add(Integer.toString(i));
        }   
        return result;
    }
```

