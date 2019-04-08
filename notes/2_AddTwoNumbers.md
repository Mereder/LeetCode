### 题目描述

You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order** and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**审题啊！！链表所表示的数字是倒序的！**

**Example:**

```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```

### 解题思路

1. 首先想到的是 分别计算l1,l2再相加  然后再根据SUM 然后建造链表。

   这么做的很大问题就是，链表是倒序的，所以访问顺序是 个十百... 不方便用  *10 相加。

2. 既然访问顺序就是 个十百千  那么正好符合我们进行加法的 从低到高 满10进1

   所以就是 诸位相加，同时 构建新的链表。只需要注意最后如果两个最高位相加进1 还需要判断。

### 题解

```java
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        int sum = 0;
        ListNode p = temp;
        while (l1 != null || l2 != null || sum !=0){
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null ){
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum%10);
            sum /= 10;
            p = p.next;
        }
        return  temp.next;
    }
```

