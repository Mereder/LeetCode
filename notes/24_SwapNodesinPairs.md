### 题目描述

Given a linked list, swap every two adjacent nodes and return its head.

You may **not** modify the values in the list's nodes, only nodes itself may be changed.

 

**Example:**

```
Given 1->2->3->4, you should return the list as 2->1->4->3.
```



### 解题思路

tail  p  q 三个指针

tial 表示 交换过的链表

p表示待交换第一个 q为第二个，即一次操作 交换p和q。



### 题解

```java
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        ListNode q = head.next;
        ListNode tail = dummy;
        while(p!= null && q!=null){
            // swap
            p.next = q.next;
            q.next = p;
            tail.next = q;
            // 
            tail = p;
            p = tail.next;
            if(p == null) break;
            q = p.next;
        }
        return dummy.next;
    }
```

