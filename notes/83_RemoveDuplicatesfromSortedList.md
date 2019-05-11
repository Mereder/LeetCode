### 题目描述

Given a sorted linked list, delete all duplicates such that each element appear only *once*.

**Example 1:**

```
Input: 1->1->2
Output: 1->2
```

**Example 2:**

```
Input: 1->1->2->3->3
Output: 1->2->3
```

### 解题思路





### 题解



```java
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode p = head;
        while(p.next != null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }
            else{
                p = p.next;
            }
        }
        return head;
    }
```

