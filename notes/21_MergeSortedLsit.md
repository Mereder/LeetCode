### 题目描述

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

**Example:**

```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```

### 解题分析

思路很简单，新建一个 表头temp，同时需要一个p指针来指向新链表的尾部。

然后将l1  l2 依次按大小顺序插入，

当插完之后 若 其中一个链表还有残余（不为NULL），直接放到放到新链表尾部（p.next）

### 题解

```java
   public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0), p = temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null)
            p.next = l1;
        if (l2 != null)
            p.next = l2;
        return temp.next;
    }
```

